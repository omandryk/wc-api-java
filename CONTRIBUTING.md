# Contributing

Issues and focused pull requests are welcome. Before proposing a substantial API change, open an issue so the design and compatibility impact can be discussed.

## Development

Requirements: JDK 8 or newer and Maven 3.8 or newer.

```bash
mvn verify -Dgpg.skip=true
```

The legacy live-store integration tests are currently disabled with JUnit's `@Ignore`. For manual testing, use a disposable WooCommerce store and supply `WC_URL`, `WC_CONSUMER_KEY`, and `WC_CONSUMER_SECRET` through environment variables. Never commit real credentials.
