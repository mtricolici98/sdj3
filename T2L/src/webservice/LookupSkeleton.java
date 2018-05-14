/**
 * LookupSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.7  Built on : Nov 20, 2017 (11:41:20 GMT)
 */
package webservice;
import java.rmi.RemoteException;

import RMIClient.*;
/**
 *  LookupSkeleton java skeleton for the axisService
 */
public class LookupSkeleton implements LookupSkeletonInterface {
    /**
     * Auto generated method signature
     *
     * @param lookup0
     * @return lookupResponse1
     */
    public webservice.LookupResponse lookup(webservice.Lookup lookup0) {
        //TODO : fill this with the necessary business logic
    	 LookupResponse ret = new LookupResponse();
         try {
 			ret.set_return(RMIClient.getInstance().getRemoteServer().getVehicleInfo(lookup0.getArgs0()));
 		} catch (RemoteException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
         return ret;

    }
}
