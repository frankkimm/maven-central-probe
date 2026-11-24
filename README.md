# Maven Central probe

Tries out the way to Maven Central before the first release of dddlens: namespace `de.kimmlingen`, GPG signature,
upload through the Central Portal, triggered by a tag. The artifact `de.kimmlingen.test:probe` has no use of its own.

## Prerequisites (once)

1. Namespace `de.kimmlingen` in the [Central Portal](https://central.sonatype.com/), verified by the TXT record of
   `kimmlingen.de` the portal names.
2. GPG key: `gpg --full-generate-key`, the public key on a key server
   (`gpg --keyserver keyserver.ubuntu.com --send-keys <id>`).
3. User token of the Central Portal (*View Account → Generate User Token*).
4. Secrets of this repository: `MAVEN_GPG_PRIVATE_KEY` (`gpg --armor --export-secret-keys <id>`),
   `MAVEN_GPG_PASSPHRASE`, `CENTRAL_TOKEN_USERNAME`, `CENTRAL_TOKEN_PASSWORD`.

## Release

```bash
git tag v0.0.1 && git push origin v0.0.1
```

The workflow `release` sets the version of the tag, builds with sources and Javadoc, signs and publishes. Maven
Central keeps every version for good; a version cannot be published twice.

Check: `mvn dependency:get -Dartifact=de.kimmlingen.test:probe:0.0.1` once the portal shows *Published*.

Locally without signature and upload: `mvn -Prelease -Dgpg.skip verify`.
