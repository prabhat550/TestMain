# Apache-Kafka

- Start up the Zookeeper
<br/> zookeeper-server-start.bat ..\..\config\zookeeper.properties

- Start up the Kafka Broker.
<br/> kafka-server-start.bat ..\..\config\server.properties

- Topic Creation
<br/> kafka-topics.bat --create --topic test-topic -zookeeper localhost:2181 --replication-factor 1 --partitions 4

- List all Topics
<br/> kafka-topics.bat --bootstrap-server localhost:9092 --list

- Describe a Topic 
<br/> kafka-topics.bat --bootstrap-server localhost:9092 --describe --topic <topic-name>
  
- Alter the partitions of a topic
 <br/>kafka-configs.bat --bootstrap-server localhost:9092 --alter --topic test-topic --partitions 40
  
- Instantiate a Console Producer
 
  Without Key 
  <br/>  kafka-console-producer.bat --broker-list localhost:9092 --topic test-topic

  With Key
  <br/> kafka-console-producer.bat --broker-list localhost:9092 --topic test-topic --property "key.separator=-" --property "parse.key=true"
  
- Instantiate a Console Consumer 
  
  Without Key
   <br/> kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test-topic --from-beginning
  
  With Key
   <br/> kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test-topic --from-beginning -property "key.separator= - " --property "print.key=true"
  
  With Consumer Group
  <br/> kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test-topic --group <group-name>
  
- View Consumer Groups
<br/> kafka-consumer-groups.bat --bootstrap-server localhost:9092 --list
  
- Viewing the Commit Log
<br/> kafka-run-class.bat kafka.tools.DumpLogSegments --deep-iteration --files /tmp/kafka-logs/test-topic-0/00000000000000000000.log
 

  
