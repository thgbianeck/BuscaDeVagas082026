#!/bin/sh
set -eu
awslocal() { aws --endpoint-url=http://localhost:4566 "$@"; }
awslocal sqs list-queues
awslocal sns list-topics
awslocal s3 ls
awslocal dynamodb list-tables
