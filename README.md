# -Financial-Health-Indicator-Tool
A tool to calculate financial health
# Step:1 Docker run for postgres
1. Open standalone folder in terminal and run
	- docker-compose -f ./postgres-docker-locale.yml up -d
2. Navigate to service>discovery-service and run the command -
	- mvn spring-boot:run
3. Navigate to service>api-gateway-service and run the command -
	- mvn spring-boot:run
4. Navigate to service>health-service and run the command -
	- mvn spring-boot:run
5. Navigate to web\financial-health-calculator and run the command 
	- npm install
6. Now run the command
	- npm start
# ports
Discovery-Service = http://localhost:8761
API-GATEWAY = http://localhost:8000
Health-Service = http://localhost:8081