# Nsys Demo (Nsys Node)

## Quick links

* [Nsys Demo][1]
* [Nsys Code][2]
* [Nsys Installation and Configuration][3]

## Description

The Nsys Demo Docker Library provides set of images and maintenance scripts for development, deployment, and testing of the [Nsys Demo](https://doc.nsys.org/display/NSYS/Nsys+Demo). See [the Docker Hub page](https://hub.docker.com/r/nsys) for the full list of available Docker images for the Nsys Demo and for information regarding contributions and issues.

[1]: https://doc.nsys.org/display/NSYS/Nsys+Demo
[2]: http://code.nsys.org
[3]: https://doc.nsys.org/display/NSYS/Nsys+Installation+and+Configuration

## Docker image nsys/nsys-demo-node

* Includes updates
* [Dockerfile and source code](https://github.com/nsys-code/nsys-demo)

### Build the Image

~~~~
$ docker build -t nsys/nsys-demo-node .
~~~~

### Build the Image via script

~~~~
$ ./build-image.sh
~~~~

### Run the Image

~~~~
$ docker run -it --rm -p 9180:9180 nsys/nsys-demo-node
~~~~

> Nsys Demo Node Administration will be available at http://localhost:9180

### Run the Image in background

~~~~
$ docker run -d -i --name nsys-demo-node -p 9180:9180 nsys/nsys-demo-node
~~~~

### Run the Image in background via script

~~~~
$ ./run-image.sh
~~~~