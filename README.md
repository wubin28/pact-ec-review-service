# The Provider Sample Project Using Pact JVM Provider

The repo "pact-ec-app" demonstrates an e-commerce application 
which depends on the "pact-ec-review-service" restful service. 
The former (as a consumer) sends requests to the latter 
(as a provider) to get rating information (5-star rating) 
for a product on the e-commerce website with product id 
and user name.

# How to Run It

0. Generate the pact (i.e. contract) of the sample application according to the README.md in the repo ["pact-ec-app"](https://github.com/wubin28/pact-ec-app).
1. Git clone the ["pact-ec-review-service"](https://github.com/wubin28/pact-ec-review-service) repo.
3. Copy the pact file generated in the consumer side in step 0 to the folder "src/test/resources" of the provider project folder.
4. Run command "mvn clean test"