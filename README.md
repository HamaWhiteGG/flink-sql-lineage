# FlinkSQL Lineage

FlinkSQL Lineage Analysis Tool, which supports advanced syntax such as Watermark, UDTF, CEP, Windowing TVFs, and CTAS.
The core idea is to parse SQL through Calcite to generate a RelNode tree, and then call RelMetadataQuery to obtain 
the field-level lineage relationship, and finally display it visually.

## Features

![Product.png](https://github.com/HamaWhiteGG/flink-sql-lineage/blob/main/data/images/Product.png)

* Support lineage at both table and column levels in Flink SQL.
* Support processing and transformation relationships for field lineage in Flink SQL.
* Visualize data lineage, displaying the total number of downstream fields for a specific column.
* Simultaneously support parsing multiple versions of Flink.
* Automatically parse JAR content when creating a new Flink UDF to populate function information.
* Support view reference jobs for custom functions.

## Architecture

![Architecture.png](https://github.com/HamaWhiteGG/flink-sql-lineage/blob/main/data/images/Architecture.png)

* Frontend development based on [Butterfly](https://github.com/alibaba/butterfly) with customizations.
* Lineage-server designed using Domain-Driven Design (DDD) architecture.
* Plugin-based design, with each Flink version corresponding to a plugin.
* Utilizing SPI and Classloaders, each plugin is loaded using a separate Classloader.

## How to Build
Prerequisites for building Flink:
* Java 8
* Unix-like environment (we use Linux, Mac OS X, Cygwin, WSL)
* Maven (we recommend version 3.8.6 and require at least 3.5.4)

```shell
git clone https://github.com/HamaWhiteGG/flink-sql-lineage.git
cd flink-sql-lineage
mvn clean package
```
> Note: If you use IntelliJ IDEA, please install the Manifold plugin.

## Support
Don’t hesitate to ask!

[Open an issue](https://github.com/HamaWhiteGG/flink-sql-lineage/issues) if you find a bug or need any help.

## Fork and Contribute
This is an active open-source project. We are always open to people who want to use the system or contribute to it. Please note that pull requests should be merged into the **dev** branch.

Contact [me](baisongxx@gmail.com) if you are looking for implementation tasks that fit your skills.


