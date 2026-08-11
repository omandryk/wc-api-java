# Releasing

Releases use the Central Publisher Portal and preserve the coordinates
`com.icoderman:wc-api-java`. The release profile uses
`org.sonatype.central:central-publishing-maven-plugin` with automatic publishing
disabled. Uploading a bundle therefore does not make it public; a maintainer must
review and publish the validated deployment in the Central Portal.

## Safety gates

- Normal pushes and pull requests never invoke the release workflow.
- The workflow is manual and defaults to `verify` mode.
- `upload` mode uses the protected `maven-central` GitHub environment and only
  accepts a `v*` tag matching the non-SNAPSHOT POM version.
- The Central plugin has `<autoPublish>false</autoPublish>`.
- Publishing the validated deployment in Central is a separate, explicit,
  irreversible action.

Configure the `maven-central` GitHub environment with required reviewers before
adding secrets. Store these environment secrets there:

- `CENTRAL_USERNAME`: username from a newly generated Central Portal user token.
- `CENTRAL_PASSWORD`: password from that token.
- `GPG_PRIVATE_KEY`: ASCII-armored export of the signing private key.
- `GPG_PASSPHRASE`: passphrase for the signing key.

Never commit credentials, private keys, passphrases, Maven `settings.xml`, or a
recovered GnuPG home. The historical signing key fingerprint is
`161A 7A08 F89C 1657 FC4F 0B75 DE35 65D0 3185 1B72`.

## Release sequence

1. Verify `master` and prepare release notes.
2. Change the POM from `1.5-SNAPSHOT` to `1.5.0` in a reviewed release PR.
3. Merge with the repository's noreply commit identity and wait for CI.
4. Create and push the signed/approved `v1.5.0` tag.
5. Dispatch this workflow from `v1.5.0` in `upload` mode.
6. Inspect the validated deployment in the Central Portal.
7. Publish it only after explicit owner approval.
8. Resolve the artifact from a clean Maven consumer before creating the GitHub
   Release and announcing availability.

For a credential-free build check, dispatch `verify` mode or run:

```bash
mvn clean verify
```

For a local signed-bundle check without deploying, use an isolated GnuPG home and
run:

```bash
GNUPGHOME=/path/to/isolated/.gnupg mvn clean verify -Prelease
```
