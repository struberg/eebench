# Small JavaEE benchmark suite


## Goals

This small webapp is intended to give you a rough feeling about various different aspects of a JavaEE server installation.

Parts of it target the performance of the EE server implementation:
 * CDI 
 * EJB 
 * EL 
 * JSF

Other parts measure the performance of the underlying hardware:
 * large file disk IO
 * small file disk IO
 * cache memory throughput (small mem chunks)
 * RAM throughput (large mem chunks)

## Running

Just deploy the WAR and browse the page. It contains a download link to an Apache JMeter (http://jmeter.apache.org) benchmark script.

### Running locally

$> mvn clean install tomee:run

Browse http://localhost:8080/eebench
