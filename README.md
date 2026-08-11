# WooCommerce API Java Wrapper

[![CI](https://github.com/omandryk/wc-api-java/actions/workflows/ci.yml/badge.svg)](https://github.com/omandryk/wc-api-java/actions/workflows/ci.yml)
[![Maven Central](https://img.shields.io/maven-central/v/com.icoderman/wc-api-java.svg)](https://central.sonatype.com/artifact/com.icoderman/wc-api-java)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

A small Java wrapper for the WooCommerce REST API, originally released in 2016 and distributed through Maven Central.

> **Project revival:** version 1.4 is the latest published release. The 1.5 line restores maintenance, testing, and modern release infrastructure while preserving the existing API. Do not use unreleased snapshots in production.

## Installation

```xml
<dependency>
  <groupId>com.icoderman</groupId>
  <artifactId>wc-api-java</artifactId>
  <version>1.4</version>
</dependency>
```

## Usage

```java
OAuthConfig config = new OAuthConfig(
    "https://store.example.com",
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
- OAuth 1.0a request signing used by the historical 1.x API

The compatibility matrix will be expanded as part of the 1.5 revival. HTTPS-first authentication and a modernized API are being evaluated separately for a future major release.

## Development

```bash
mvn verify -Dgpg.skip=true
```

See [CONTRIBUTING.md](CONTRIBUTING.md) and [SECURITY.md](SECURITY.md) before opening an issue or pull request.

## License

MIT © Oleksandr Mandryk
