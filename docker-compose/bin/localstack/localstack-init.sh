#!/usr/bin/env bash

readonly LOCALSTACK_URL=http://localhost:4566
readonly REGION=us-east-1

sleep 5;

set -x
aws configure set aws_acess_key_id algum_access
aws configure set aws_secret_acess_key algum_secret
aws configure set region $REGION
aws configure set output json

aws --endpoint $LOCALSTACK_URL sqs create-queue --queue-name usuario-queue --attributes DelaySeconds=60,MessageRetentionPeriod=86400

aws --endpoint $LOCALSTACK_URL dynamodb create-table \
    --table-name usuario_entity \
    --attribute-definitions \
        AttributeName=nome,AttributeType=S \
        AttributeName=id_usuario,AttributeType=S \
    --key-schema \
        AttributeName=nome,KeyType=HASH \
        AttributeName=id_usuario,KeyType=RANGE \
    --provisioned-throughput \
        ReadCapacityUnits=5,WriteCapacityUnits=5
