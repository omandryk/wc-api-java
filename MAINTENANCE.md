# Maintenance policy

`wc-api-java` 1.x is a maintained legacy client. Maintenance is deliberately bounded so existing users can keep resolving a stable artifact without implying feature parity with the current WooCommerce REST API.

## In scope for 1.x

- Security and maintained dependency updates compatible with Java 8.
- Reproducible, backward-compatible bug fixes with regression tests.
- CI, build, release, and documentation maintenance.
- Clear answers about confirmed 1.x behavior and limitations.

## Out of scope for 1.x

- Breaking public API changes.
- Comprehensive typed models or complete endpoint coverage.
- New authentication architecture, including HTTPS Basic Authentication.
- Automatically generated API clients or speculative fixes without reproducible evidence.

These items require a separately evaluated major version. No 2.x roadmap is currently committed.

## Quality and release gates

Code changes require focused tests and a green Java 8, 11, 17, and 21 CI matrix. Authentication, signing, and request-encoding changes additionally require deterministic test vectors and WooCommerce compatibility evidence.

Every Maven Central release requires a human-approved pull request, signed release candidate, independent consumer-resolution check, protected deployment approval, and manual Central publication. Automation may monitor, reproduce, and draft changes, but it may not comment, merge, tag, or publish autonomously.

## Reporting issues

Include the library version, Java version, WooCommerce version, endpoint, minimal reproduction, expected behavior, and sanitized response details. Never include consumer secrets, access tokens, order/customer data, or private store URLs.
