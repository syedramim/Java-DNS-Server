# Java DNS Server

## Overview

This project is a lightweight Domain Name System (DNS) server written in Java. It responds to DNS queries using data from a custom-formatted zone file and supports A and NS record types. The server operates over UDP and includes a basic DNS cache with TTL expiration support.

The project demonstrates key networking concepts such as socket programming, binary protocol parsing, and DNS message handling.

## Features

- UDP-based DNS query handling (standard port 53)
- Parses A and NS records from a zone file
- Caches DNS responses with TTL enforcement
- Builds and parses DNS messages to conform with protocol format
- Modular design with separate classes for zone handling, messages, caching, and the server core

## Project Structure

```
Java-DNS-Server/
├── .gitignore
├── Makefile
├── README.md
└── dns/
    ├── DNSCache.java
    ├── DNSMessage.java
    ├── DNSRecord.java
    ├── DNSServer.java
    └── DNSZone.java
```

> 📝 Note: The example zone file (`csci3363.zone`) used during development is **excluded** from this repository to avoid publishing coursework-provided materials. You can supply your own zone file in a compatible format (see below).

## Zone File Format

To test this DNS server, you will need to create a zone file with records in the following format:

```
example.com A 1.2.3.4 60
example.com NS ns1.example.com 60
```

- **Format**: `<domain> <type> <value> <ttl>`
- **Supported types**: `A`, `NS`
- **TTL**: Time to live, in seconds

Save this file as `yourdomain.zone` and reference it when running the server.

## How to Compile and Run

### Compile

```bash
make
```

### Run the Server

```bash
java dns.DNSServer <port> <zone-file>
```

Example:
```bash
java dns.DNSServer 8053 yourdomain.zone
```

### Test with `dig`

You can test it using the `dig` command:

```bash
dig @localhost -p 8053 example.com
```

## Concepts Demonstrated

- Socket programming with UDP
- DNS protocol parsing and construction
- Caching logic and TTL expiration
- File parsing and validation
- Binary message handling with Java byte arrays

## Attribution

This project was developed as part of **CSCI3363: Computer Networks**, taught by **Professor Wiseman** at **Boston College**. While the structure and specifications were provided by the instructor, the full Java implementation was created by myself and is published here for educational and demonstration purposes.

## License

This project is provided for educational and portfolio use. Please do not redistribute or reuse without proper attribution. Do not submit any part of this code for academic credit without authorization.

