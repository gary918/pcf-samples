# pcf-samples

A demo for deploying Spring Boot applications in PWS.

1. Sign up an account for PWS (https://console.run.pivotal.io)
2. Create a Service Registry named 'service-registry' in PWS
3. Create a ClearDB MySQL Database named 'garydb' in PWS
4. Deploy the Spring Boot application, 'account' to PWS
5. Bind 'account' with 'service-registry'
6. Bind 'account' with 'garydb'
7. Deploy the Spring Boot application, 'search' to PWS
8. Bind 'search' with 'service-registry'
9. Access account search service through the browser:'search'->'account'

