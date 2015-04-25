Nsys Demo
=========

About
----------------------

This is an example of software application based on customized distribution of the Nsys Platform.


Quick Installation
----------------------

Requirements:
* Oracle JDK 1.7+ or Open JDK 1.7+ (Java)

If your system does not meet the above requirements, please read the
installation documentation: http://doc.nsys.org


### Linux and Mac

1. At first we need to set correct permissions for scripts
	$ chmod -R 755 <Nsys installation directory>/bin/*.sh

2. Edit `<Nsys installation directory>/bin/nsys-daemon.env.sh`

3. Set `NSYS_HOME` by uncommenting the `NSYS_HOME` line and adding the
   absolute path to the directory where you want Nsys to store your data.

4. In a terminal, run:
    `<Nsys installation directory>/bin/nsys-launcher.sh nsys-daemon run`

5. In your browser go to:
    `http://localhost:9180`

6. To run Nsys Daemon as system service you need to follow instructions below:

	NOTE: In example below the <Nsys installation directory> is /opt/${nsys.dist.name}
	
	$ adduser --system --shell /bin/bash --gecos 'Nsys Platform Control' --group --disabled-password --home /opt/${nsys.dist.name} ${nsys.dist.name}
	$ cp /opt/${nsys.dist.name}/bin/${nsys.dist.name}-daemon.sh /etc/init.d/${nsys.dist.name}-daemon
	$ chmod a+x /etc/init.d/${nsys.dist.name}-daemon
	$ update-rc.d ${nsys.dist.name}-daemon defaults
	$ /etc/init.d/${nsys.dist.name}-daemon start
	

Licensing
----------------------

See http://www.nsys.org/license
