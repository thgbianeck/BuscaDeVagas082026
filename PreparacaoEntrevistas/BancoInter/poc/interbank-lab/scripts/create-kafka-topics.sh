#!/bin/sh
set -eu
TOPICS="banking.transfer.requested.v1 banking.transfer.fraud-approved.v1 banking.transfer.fraud-rejected.v1 banking.account.debited.v1 banking.account.credited.v1 banking.ledger.entry-created.v1 banking.transfer.completed.v1 banking.transfer.failed.v1 banking.notification.requested.v1"
for topic in $TOPICS; do docker compose --profile core exec -T kafka /opt/kafka/bin/kafka-topics.sh --bootstrap-server kafka:9092 --create --if-not-exists --topic "$topic" --partitions 3 --replication-factor 1; done
