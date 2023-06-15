# VesselSearch Backend #
This is the backend for the VesselSearch application. Together with the frontend, it allows the user to search for vessels in the database and view their details. The backend is written in Java Spring Boot, and the frontend is written in React, implemented with Typescript. The database is a MySQL database.

See the README.md in the frontend folder for more information about the frontend.

##How to run##
- Ensure that you have Java 11 installed, and that you have a MySQL database running on port 3306. The database must be created initially, and you can use Postman to add vessels and corresponding certificates to the database. 

Below are available endpoints:
### Add certificate to a vessel (POST)###
```sh
localhost:8080/certificate/add
```
JSON-body example:
```sh
{
    "certificateId": 1,
    "certificateName": "BC - name of certificate",
    "certificateType": "BC",
    "vessel": {
        "vesselId": 1
    },
    "startDate": "2020-01-01",
    "endDate": "2020-12-31"
}
```
The vesselId in the JSON format specifies which vessel the certificate is issued for.

### Add vessel (POST)###
```sh
localhost:8080/vessel/add
```
JSON-body example:
```sh
{
    "vesselId": 1,
    "vesselName": "Vessel 1",
    "imoNumber": 1234567
}
```

### Get all vessels with respective their certificates (GET) ###
```sh
localhost:8080/vessel/getAllWithCertificates
```

### Get vessel by ImoNumber or vesselName/substring of vesselName (GET) ###
```sh
localhost:8080/vessel/search?searchTerm={searchTerm}
```

The searchTerm is a string that can be used to search for vessels. The search is done on the vesselName and imoNumber fields. The search is case insensitive, and the searchTerm can be a substring of the vesselName. ImoNumber must be an exact match.

All endpoints can be tested with Postman. Only the GET endpoint can be tested in the browser, the POST endpoints must be done through Postman.

Once you have a database running, and have added some relevant data, you can run the backend by running the following command in the backend folder:
```sh
cd vesselsearch
mvn spring-boot:run
```
The backend will then run on port 8080.
Proceed to the frontend folder, Do the following:
```sh
cd vsui
npm install
npm start
```
If some dependencies are missing, you can install them specifically with npm install. The frontend will then run on port 3000 (which is a port that is whitelisted by the backend through the CorsConfig class).