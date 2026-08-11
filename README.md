# WooCommerce API Java Wrapper

[![CI](https://github.com/omandryk/wc-api-java/actions/workflows/ci.yml/badge.svg)](https://github.com/omandryk/wc-api-java/actions/workflows/ci.yml)
[![Maven Central](https://img.shields.io/maven-central/v/com.icoderman/wc-api-java.svg)](https://central.sonatype.com/artifact/com.icoderman/wc-api-java)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

A small Java wrapper for the WooCommerce REST API, originally released in 2016 and distributed through Maven Central.

I originally created this library while building automation for a client's WordPress/WooCommerce store from a Java application. The project later found users of its own, even though it received very little maintenance for almost a decade.

> **Maintenance release:** version 1.5.0 restores supported dependencies, CI, release infrastructure, and a tested community fix while preserving the 1.x public API. This is a maintained legacy client, not an official WooCommerce SDK.

WooCommerce currently lists this repository among the third-party Java libraries in its [REST API documentation](https://developer.woocommerce.com/docs/apis/rest-api/). WooCommerce does not provide support for third-party libraries.

## Installation

```xml
<dependency>
  <groupId>com.icoderman</groupId>
  <artifactId>wc-api-java</artifactId>
  <version>1.5.0</version>
</dependency>
```

## Usage

```java
OAuthConfig config = new OAuthConfig(
    "http://localhost",
    System.getenv("WC_CONSUMER_KEY"),
    System.getenv("WC_CONSUMER_SECRET")
);
WooCommerce wooCommerce = new WooCommerceAPI(config, ApiVersionType.V3);

Map<String, String> params = new HashMap<>();
params.put("per_page", "100");
List products = wooCommerce.getAll(EndpointBaseType.PRODUCTS.getValue(), params);
```

Never commit WooCommerce credentials. Supply them through a secret manager or environment variables.

## Compatibility

- Java 8 or newer
- WooCommerce REST API v2/v3 endpoints
- Legacy OAuth 1.0a request signing over HTTP

The 1.x client does not implement WooCommerce HTTPS Basic Authentication. Use it only in a controlled environment until HTTPS-first authentication is available in a future major release.

## Maintenance status

The 1.x line receives bounded maintenance for dependency/security updates, reproducible bug fixes, CI compatibility, and documentation corrections. New endpoints, broad API modeling, and breaking changes are outside the 1.x scope.

See [MAINTENANCE.md](MAINTENANCE.md) for the support policy and release gates.

## Development

```bash
mvn verify -Dgpg.skip=true
```

Maintainers preparing a Central release should follow [RELEASING.md](RELEASING.md).

See [CONTRIBUTING.md](CONTRIBUTING.md) and [SECURITY.md](SECURITY.md) before opening an issue or pull request.

## License

MIT © Oleksandr Mandryk
