# FlinkSQL Lineage

The Lineage Analysis system for FlinkSQL supports advanced syntax such as Watermark, UDTF, CEP, Windowing TVFs, and CTAS. The core process involves parsing SQL using Calcite to generate a RelNode tree. Subsequently, RelMetadataQuery is utilized to retrieve field-level lineage information, which is then presented through visualization.

> If you are interested, you can add me on WeChat: HamaWhite, or send email to baisongxx@gmail.com

## Features

![Product.gif](https://github.com/HamaWhiteGG/flink-sql-lineage/blob/main/data/images/Product.gif)

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

## Principle

![Principle.png](https://github.com/HamaWhiteGG/flink-sql-lineage/blob/main/data/images/Principle.png)

1. Syntax parsing involves converting Flink SQL into an Abstract Syntax Tree (AST), where Calcite uses SqlNode for representation.
2. Syntax validation is performed by leveraging metadata information for syntax verification, resulting in AST composed of SqlNode elements.
3. Semantic analysis entails constructing a RelNode tree based on SqlNode and metadata information.
4. The getColumnOrigins(RelNode rel, int column) function from RelMetadataQuery is invoked to query original field details.

> If encountering unresolved lineage relationships, please examine the types within the RelNode Tree. 
> Generally, to accurately parse them, you can add corresponding methods within the RelMdColumnOrigins class in the source code.


## Build and Deploy
Prerequisites for building Flink:
* Java 8
* Unix-like environment (we use Linux, Mac OS X, Cygwin, WSL)
* Maven (we recommend version 3.8.6 and require at least 3.5.4)

```shell
git clone https://github.com/HamaWhiteGG/flink-sql-lineage.git
cd flink-sql-lineage

# export JAVA_HOME=JDK8_INSTALL_HOME && mvn clean package
mvn clean package
```
> Note: If you use IntelliJ IDEA, please install the Manifold plugin.

The database is MySQL, and scripts are located in the directory [scripts/mysql](scripts/mysql).

If you don't have MySQL, you can switch to the test profile to quick start (which uses the H2 database).

Then Run [LineageServerApplication](lineage-server/lineage-server-start/src/main/java/com/hw/lineage/server/start/LineageServerApplication.java) and then open http://127.0.0.1:8194.

For deploy on a remote server, you can quickly deploy using [deploy.sh](sbin/deploy.sh) (remember to modify the IP).
```shell
# export JAVA_HOME=JDK8_INSTALL_HOME && sh sbin/deploy.sh
sh sbin/deploy.sh
```

If you prefer to deploy using Docker Compose, run the following command:
```shell
# export JAVA_HOME=JDK8_INSTALL_HOME && sh sbin/start-docker-compose.sh
sh sbin/start-docker-compose.sh
```


## Support
Don’t hesitate to ask!

[Open an issue](https://github.com/HamaWhiteGG/flink-sql-lineage/issues) if you find a bug or need any help.

## Fork and Contribute
This is an active open-source project. We are always open to people who want to use the system or contribute to it. Please note that pull requests should be merged into the **dev** branch.

Contact [me](baisongxx@gmail.com) if you are looking for implementation tasks that fit your skills.


