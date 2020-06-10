# MS
This project's main aims is to have understanding of frameworks, tools for Microservice development & deployment based on Microprofile Secficication.

The business functionality of the project is to expose APIs to list down Orders & Customers.  Order data is having Order Id ,Customer Id, Transaction Amount. Customer data is having Customer Id, Name, Age.</br>

This project is updated to deprecate/add tools, farmeworks, packages in favour of making project more cloud native, performant and  feature rich. Each version captures description of the changes from previous version.</br>

### Base Framework & Tools

 - Open JDK 11    
 - Quarkus  
 - Maven 
 - Docker 
 - Kubernetes
 - H2 (InMemory DB)
 
### Project Modules

 - customer_service - Customer Service
 - order_service - Order Service
 
## 0.0.1 - Microservices using Spring Boot & Kubernetes , Deployment by Kubernetes

### Microservice Components
|| Spring Component | Reference|
|--|--|--|
| Service | Quarkus RestEsay |customer_service, order_service|
| Config | Quarkus Config |customer_service, order_service|
| Service Registry | Kubernetes Service |kubernetes.yml *[Project Specific]*|
| Service Discovery  | Kubernetes | kubernetes.yml *[Project Specific]*, ms-ingress.yml|
| Fault Tolerence   | Quarkus Smallrye Fault Tolerance |order_service|
| API Gateway | Kubernetes Ingress (Nginx) |ms-ingress.yml|
| Service Client  | Quarkus Rest Client |order_service|
| Trace Logging  | Quarkus Smallrye Opentracing |customer_service, order_service|
| Health Monitor  | Quarkus Smallrye Health, Quarkus Smallrye Monitor |scustomer_service, order_service|

### Containerisation
|| Component | Reference|
|--|--|--|
| Image Build | Spring Maven, Docker | customer_service, order_service, Dockerfile.jvm *[Project Specific]*|
| Orchestration | Kubernetes | kubernetes.yml *[Project Specific]* |

### Performance 
|| Jar Size (mB) | Image Size (MB) | Start up Time (s)|
|--|--|--|--|
| customer_service | 0.5 | 535  | 14 |
| order_service | 0.6 | 538  | 19 |
