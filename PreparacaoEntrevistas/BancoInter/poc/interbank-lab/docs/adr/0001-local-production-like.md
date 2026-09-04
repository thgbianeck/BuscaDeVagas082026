# ADR-0001: Ambiente local production-like

## Status
Aceita

## Contexto
A POC precisa exercitar mensageria, bancos, identidade, observabilidade e integrações AWS sem gerar custo de nuvem.

## Decisão
Usar Docker Compose com perfis, volumes, health checks, redes isoladas e emuladores locais. A aplicação dependerá de portas/adaptadores, não de detalhes do emulador.

## Consequências
O laboratório é reproduzível e barato, mas não valida escala, disponibilidade, latência, IAM ou limites reais de um provedor de nuvem.
