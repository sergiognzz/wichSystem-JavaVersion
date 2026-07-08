# wichSystem-JavaVersion

Herramienta para descubrir el posible SO en base al TTL para CTFs, inspirada en el famoso `wichSystem.py` de S4vitar. Es un homenaje a S4vitar con un script programado en Java.

## Usage

```bash
java wichSystem.java <IPADDRESS>
```

## Example

```bash
java wichSystem.java 192.168.1.143
```

## Output

```text
--------------------------------------------
Fetching TTL for IP address: 192.168.1.143
Detected OS: Linux
TTL value: 64
--------------------------------------------
```
