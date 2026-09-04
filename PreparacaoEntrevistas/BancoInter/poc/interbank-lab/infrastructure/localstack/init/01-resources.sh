#!/bin/sh
set -eu
awslocal sqs create-queue --queue-name interbank-notifications
awslocal sqs create-queue --queue-name interbank-notifications-dlq
awslocal sns create-topic --name interbank-events
awslocal s3 mb s3://interbank-audit-local
awslocal dynamodb create-table --table-name interbank-idempotency --attribute-definitions AttributeName=id,AttributeType=S --key-schema AttributeName=id,KeyType=HASH --billing-mode PAY_PER_REQUEST
