# dubbo-contract-test
[![Build Status](https://tianyawy.visualstudio.com/dubbo-contract-test/_apis/build/status/victoryw.dubbo-contract-test?branchName=master)](https://tianyawy.visualstudio.com/dubbo-contract-test/_build/latest?definitionId=3&branchName=master)
## How to use
### Online
- dubbo admin: http://23.97.72.214:8080 
- duboo provider: dubbo://10.0.198.6:12345
- duboo consumer: http://10.0.4.130:8080/say-hello?name=wy
- zookeeper: zookeepr://10.0.153.115:2181

### Local
- package & test: mvn package
- docker image: docker-compose -f docker-compose-build.yml build
- start service: docker-compose up -d

## Folder struct
``` 
.
├── consumer
├── contract-file
├── k8s
└── provider
```
* contract-file contains the interface file
* provider will be the dubbo service provider hosted in the spring boot env
* consumer will be the dubbo service consumer hosted in the spring boot env

## Provider
Provider will support:
- publish service directly in default profile
- publish service to zookeeper in zookeeper profile
- test service by directly call both dubbo protocol and rest protocol, setting in the test and test-rest profile in the test folder

## Consumer
Consumer will supprot:
- dirctly call provider service in default profile
- call provider by zookeeper in zookeeper profile
- test service by stub and ignore connect error when start service in test profile

## road map
* upgrade dubbo to 2.7
* fix the health check issue
* more and complex use case
* dubbo-swagger support
* change the online http service export way from lb to application gateway + ingress
* use the azure pipeline multi-stage to build
