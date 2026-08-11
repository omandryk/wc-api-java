# Contributing

Issues and focused pull requests are welcome. Before proposing a substantial API change, open an issue so the design and compatibility impact can be discussed.

## Development

Requirements: JDK 8 or newer and Maven 3.8 or newer.

```bash
mvn verify -Dgpg.skip=true
```

Integration tests require a disposable WooCommerce store and credentials supplied through `WC_URL`, `WC_CONSUMER_KEY`, and `WC_CONSUMER_SECRET`. Never commit real credentials.
