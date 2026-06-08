# eBPF Observability Demo

This repository contains the demo application for the article [Reinventing Observability with eBPF: Kernel-Level Insights for Modern Backend Systems](#).

It models a simple e-commerce orders service built with Kotlin and Spring Boot, backed by PostgreSQL, and deployed to Kubernetes. The service deliberately exposes three performance characteristics for observability demos:

- `GET /api/orders`: fast path, straightforward query
- `GET /api/orders/slow`: simulates a slow database query using `pg_sleep(0.5)`
- `GET /api/orders/n1`: triggers an N+1 query pattern by loading each customer individually

## Prerequisites

- Linux environment (eBPF requires a Linux kernel)
- Docker, kubectl, Helm, and [k3s](https://docs.k3s.io/quick-start)
- [Pixie CLI](https://docs.px.dev/installing-pixie/install-schemes/cli/#1.-install-the-pixie-cli)

## Getting Started

Follow the full tutorial in the article linked above for step-by-step instructions on deploying the service and using Pixie to observe it.

## Repository Structure

```
orders-service/
├── src/                  # Kotlin source code
├── k8s/                  # Kubernetes manifests
│   ├── namespace.yaml
│   ├── postgres.yaml
│   └── orders-service.yaml
├── Dockerfile
└── build.gradle.kts
```
