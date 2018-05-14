/**
 * HelloSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.7  Built on : Nov 20, 2017 (11:41:20 GMT)
 */
package webservice;


/**
 *  HelloSkeleton java skeleton for the axisService
 */
public class HelloSkeleton implements HelloSkeletonInterface {
    /**
     * Auto generated method signature
     *
     * @param getHelloText0
     * @return getHelloTextResponse1
     */
    public webservice.GetHelloTextResponse getHelloText(
        webservice.GetHelloText getHelloText0) {
        //TODO : fill this with the necessary business logic
       // throw new java.lang.UnsupportedOperationException("Please implement " +
       //     this.getClass().getName() + "#getHelloText");
    	
    	System.out.println( "getHelloText called" );

    	 GetHelloTextResponse res = new GetHelloTextResponse();

    	 res.set_return( "Goodbye World" );

    	 return res;
    }
}
