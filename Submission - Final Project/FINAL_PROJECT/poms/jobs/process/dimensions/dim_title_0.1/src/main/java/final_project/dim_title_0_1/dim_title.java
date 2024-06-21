
package final_project.dim_title_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.SQLike;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 





@SuppressWarnings("unused")

/**
 * Job: dim_title Purpose: <br>
 * Description:  <br>
 * @author gorle.g@northeastern.edu
 * @version 8.0.1.20230913_0925-patch
 * @status 
 */
public class dim_title implements TalendJob {
	static {System.setProperty("TalendJob.log", "dim_title.log");}

	

	
	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(dim_title.class);
	

protected static void logIgnoredError(String message, Throwable cause) {
       log.error(message, cause);

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";
	

	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
		

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
			if(MySqlLocal_Password != null){
				
					this.setProperty("MySqlLocal_Password", MySqlLocal_Password.toString());
				
			}
			
			if(MySqlLocal_AdditionalParams != null){
				
					this.setProperty("MySqlLocal_AdditionalParams", MySqlLocal_AdditionalParams.toString());
				
			}
			
			if(MySqlLocal_Login != null){
				
					this.setProperty("MySqlLocal_Login", MySqlLocal_Login.toString());
				
			}
			
			if(MySqlLocal_Database != null){
				
					this.setProperty("MySqlLocal_Database", MySqlLocal_Database.toString());
				
			}
			
			if(MySqlLocal_Server != null){
				
					this.setProperty("MySqlLocal_Server", MySqlLocal_Server.toString());
				
			}
			
			if(MySqlLocal_Port != null){
				
					this.setProperty("MySqlLocal_Port", MySqlLocal_Port.toString());
				
			}
			
			if(job_name != null){
				
					this.setProperty("job_name", job_name.toString());
				
			}
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

public java.lang.String MySqlLocal_Password;
public java.lang.String getMySqlLocal_Password(){
	return this.MySqlLocal_Password;
}
public String MySqlLocal_AdditionalParams;
public String getMySqlLocal_AdditionalParams(){
	return this.MySqlLocal_AdditionalParams;
}
public String MySqlLocal_Login;
public String getMySqlLocal_Login(){
	return this.MySqlLocal_Login;
}
public String MySqlLocal_Database;
public String getMySqlLocal_Database(){
	return this.MySqlLocal_Database;
}
public String MySqlLocal_Server;
public String getMySqlLocal_Server(){
	return this.MySqlLocal_Server;
}
public String MySqlLocal_Port;
public String getMySqlLocal_Port(){
	return this.MySqlLocal_Port;
}
public String job_name;
public String getJob_name(){
	return this.job_name;
}
	}
			
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "dim_title";
	private final String projectName = "FINAL_PROJECT";
	public Integer errorCode = null;
	private String currentComponent = "";
	
	private String cLabel =  null;
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName, "_vosH0JE5Ee6zXrZhesgs5g", "0.1");
private org.talend.job.audit.JobAuditLogger auditLogger_talendJobLog = null;

private RunStat runStat = new RunStat(talendJobLog, System.getProperty("audit.interval"));

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
                    dataSources.put(entry.getKey(), entry.getValue());
                    talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}


private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	
	private String currentComponent = null;
	private String cLabel =  null;
	
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}
	
	private TalendException(Exception e, String errorComponent, String errorComponentLabel, final java.util.Map<String, Object> globalMap) {
		this(e, errorComponent, globalMap);
		this.cLabel = errorComponentLabel;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				dim_title.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(dim_title.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
		if(enableLogStash) {
			talendJobLog.addJobExceptionMessage(currentComponent, cLabel, null, e);
			talendJobLogProcess(globalMap);
		}
			}
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tUnite_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBSCD_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tPrejob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tPrejob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tPostjob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tPostjob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void talendJobLog_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					talendJobLog_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tPrejob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tPostjob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void talendJobLog_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	



public static class toScdStruct implements routines.system.IPersistableRow<toScdStruct> {
    final static byte[] commonByteArrayLock_FINAL_PROJECT_dim_title = new byte[0];
    static byte[] commonByteArray_FINAL_PROJECT_dim_title = new byte[0];

	
			    public String tconst;

				public String getTconst () {
					return this.tconst;
				}

				public Boolean tconstIsNullable(){
				    return true;
				}
				public Boolean tconstIsKey(){
				    return false;
				}
				public Integer tconstLength(){
				    return 10;
				}
				public Integer tconstPrecision(){
				    return 0;
				}
				public String tconstDefault(){
				
					return null;
				
				}
				public String tconstComment(){
				
				    return "";
				
				}
				public String tconstPattern(){
				
					return "";
				
				}
				public String tconstOriginalDbColumnName(){
				
					return "tconst";
				
				}

				
			    public String Title;

				public String getTitle () {
					return this.Title;
				}

				public Boolean TitleIsNullable(){
				    return true;
				}
				public Boolean TitleIsKey(){
				    return false;
				}
				public Integer TitleLength(){
				    return 1024;
				}
				public Integer TitlePrecision(){
				    return 0;
				}
				public String TitleDefault(){
				
					return null;
				
				}
				public String TitleComment(){
				
				    return "";
				
				}
				public String TitlePattern(){
				
					return "";
				
				}
				public String TitleOriginalDbColumnName(){
				
					return "Title";
				
				}

				
			    public java.util.Date scd_start;

				public java.util.Date getScd_start () {
					return this.scd_start;
				}

				public Boolean scd_startIsNullable(){
				    return true;
				}
				public Boolean scd_startIsKey(){
				    return false;
				}
				public Integer scd_startLength(){
				    return 19;
				}
				public Integer scd_startPrecision(){
				    return 0;
				}
				public String scd_startDefault(){
				
					return null;
				
				}
				public String scd_startComment(){
				
				    return "";
				
				}
				public String scd_startPattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String scd_startOriginalDbColumnName(){
				
					return "scd_start";
				
				}

				
			    public java.util.Date DI_CreatedDate;

				public java.util.Date getDI_CreatedDate () {
					return this.DI_CreatedDate;
				}

				public Boolean DI_CreatedDateIsNullable(){
				    return true;
				}
				public Boolean DI_CreatedDateIsKey(){
				    return false;
				}
				public Integer DI_CreatedDateLength(){
				    return 19;
				}
				public Integer DI_CreatedDatePrecision(){
				    return 0;
				}
				public String DI_CreatedDateDefault(){
				
					return null;
				
				}
				public String DI_CreatedDateComment(){
				
				    return "";
				
				}
				public String DI_CreatedDatePattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String DI_CreatedDateOriginalDbColumnName(){
				
					return "DI_CreatedDate";
				
				}

				
			    public String DI_WorkflowJobId;

				public String getDI_WorkflowJobId () {
					return this.DI_WorkflowJobId;
				}

				public Boolean DI_WorkflowJobIdIsNullable(){
				    return true;
				}
				public Boolean DI_WorkflowJobIdIsKey(){
				    return false;
				}
				public Integer DI_WorkflowJobIdLength(){
				    return 8;
				}
				public Integer DI_WorkflowJobIdPrecision(){
				    return 0;
				}
				public String DI_WorkflowJobIdDefault(){
				
					return null;
				
				}
				public String DI_WorkflowJobIdComment(){
				
				    return "";
				
				}
				public String DI_WorkflowJobIdPattern(){
				
					return "";
				
				}
				public String DI_WorkflowJobIdOriginalDbColumnName(){
				
					return "DI_WorkflowJobId";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_dim_title.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_dim_title.length == 0) {
   					commonByteArray_FINAL_PROJECT_dim_title = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_dim_title = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_FINAL_PROJECT_dim_title, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_dim_title, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_dim_title.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_dim_title.length == 0) {
   					commonByteArray_FINAL_PROJECT_dim_title = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_dim_title = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_FINAL_PROJECT_dim_title, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_dim_title, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_dim_title) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.Title = readString(dis);
					
					this.scd_start = readDate(dis);
					
					this.DI_CreatedDate = readDate(dis);
					
					this.DI_WorkflowJobId = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_dim_title) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.Title = readString(dis);
					
					this.scd_start = readDate(dis);
					
					this.DI_CreatedDate = readDate(dis);
					
					this.DI_WorkflowJobId = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.tconst,dos);
					
					// String
				
						writeString(this.Title,dos);
					
					// java.util.Date
				
						writeDate(this.scd_start,dos);
					
					// java.util.Date
				
						writeDate(this.DI_CreatedDate,dos);
					
					// String
				
						writeString(this.DI_WorkflowJobId,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.tconst,dos);
					
					// String
				
						writeString(this.Title,dos);
					
					// java.util.Date
				
						writeDate(this.scd_start,dos);
					
					// java.util.Date
				
						writeDate(this.DI_CreatedDate,dos);
					
					// String
				
						writeString(this.DI_WorkflowJobId,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("tconst="+tconst);
		sb.append(",Title="+Title);
		sb.append(",scd_start="+String.valueOf(scd_start));
		sb.append(",DI_CreatedDate="+String.valueOf(DI_CreatedDate));
		sb.append(",DI_WorkflowJobId="+DI_WorkflowJobId);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(tconst == null){
        					sb.append("<null>");
        				}else{
            				sb.append(tconst);
            			}
            		
        			sb.append("|");
        		
        				if(Title == null){
        					sb.append("<null>");
        				}else{
            				sb.append(Title);
            			}
            		
        			sb.append("|");
        		
        				if(scd_start == null){
        					sb.append("<null>");
        				}else{
            				sb.append(scd_start);
            			}
            		
        			sb.append("|");
        		
        				if(DI_CreatedDate == null){
        					sb.append("<null>");
        				}else{
            				sb.append(DI_CreatedDate);
            			}
            		
        			sb.append("|");
        		
        				if(DI_WorkflowJobId == null){
        					sb.append("<null>");
        				}else{
            				sb.append(DI_WorkflowJobId);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(toScdStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
    final static byte[] commonByteArrayLock_FINAL_PROJECT_dim_title = new byte[0];
    static byte[] commonByteArray_FINAL_PROJECT_dim_title = new byte[0];

	
			    public String tconst;

				public String getTconst () {
					return this.tconst;
				}

				public Boolean tconstIsNullable(){
				    return false;
				}
				public Boolean tconstIsKey(){
				    return false;
				}
				public Integer tconstLength(){
				    return 10;
				}
				public Integer tconstPrecision(){
				    return 0;
				}
				public String tconstDefault(){
				
					return null;
				
				}
				public String tconstComment(){
				
				    return "";
				
				}
				public String tconstPattern(){
				
					return "";
				
				}
				public String tconstOriginalDbColumnName(){
				
					return "tconst";
				
				}

				
			    public String primaryTitle;

				public String getPrimaryTitle () {
					return this.primaryTitle;
				}

				public Boolean primaryTitleIsNullable(){
				    return true;
				}
				public Boolean primaryTitleIsKey(){
				    return false;
				}
				public Integer primaryTitleLength(){
				    return 1024;
				}
				public Integer primaryTitlePrecision(){
				    return 0;
				}
				public String primaryTitleDefault(){
				
					return null;
				
				}
				public String primaryTitleComment(){
				
				    return "";
				
				}
				public String primaryTitlePattern(){
				
					return "";
				
				}
				public String primaryTitleOriginalDbColumnName(){
				
					return "primaryTitle";
				
				}

				
			    public java.util.Date DI_Create_DT;

				public java.util.Date getDI_Create_DT () {
					return this.DI_Create_DT;
				}

				public Boolean DI_Create_DTIsNullable(){
				    return false;
				}
				public Boolean DI_Create_DTIsKey(){
				    return false;
				}
				public Integer DI_Create_DTLength(){
				    return 19;
				}
				public Integer DI_Create_DTPrecision(){
				    return 0;
				}
				public String DI_Create_DTDefault(){
				
					return null;
				
				}
				public String DI_Create_DTComment(){
				
				    return "";
				
				}
				public String DI_Create_DTPattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String DI_Create_DTOriginalDbColumnName(){
				
					return "DI_Create_DT";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_dim_title.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_dim_title.length == 0) {
   					commonByteArray_FINAL_PROJECT_dim_title = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_dim_title = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_FINAL_PROJECT_dim_title, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_dim_title, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_dim_title.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_dim_title.length == 0) {
   					commonByteArray_FINAL_PROJECT_dim_title = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_dim_title = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_FINAL_PROJECT_dim_title, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_dim_title, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_dim_title) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.primaryTitle = readString(dis);
					
					this.DI_Create_DT = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_dim_title) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.primaryTitle = readString(dis);
					
					this.DI_Create_DT = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.tconst,dos);
					
					// String
				
						writeString(this.primaryTitle,dos);
					
					// java.util.Date
				
						writeDate(this.DI_Create_DT,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.tconst,dos);
					
					// String
				
						writeString(this.primaryTitle,dos);
					
					// java.util.Date
				
						writeDate(this.DI_Create_DT,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("tconst="+tconst);
		sb.append(",primaryTitle="+primaryTitle);
		sb.append(",DI_Create_DT="+String.valueOf(DI_Create_DT));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(tconst == null){
        					sb.append("<null>");
        				}else{
            				sb.append(tconst);
            			}
            		
        			sb.append("|");
        		
        				if(primaryTitle == null){
        					sb.append("<null>");
        				}else{
            				sb.append(primaryTitle);
            			}
            		
        			sb.append("|");
        		
        				if(DI_Create_DT == null){
        					sb.append("<null>");
        				}else{
            				sb.append(DI_Create_DT);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_FINAL_PROJECT_dim_title = new byte[0];
    static byte[] commonByteArray_FINAL_PROJECT_dim_title = new byte[0];

	
			    public String tconst;

				public String getTconst () {
					return this.tconst;
				}

				public Boolean tconstIsNullable(){
				    return false;
				}
				public Boolean tconstIsKey(){
				    return false;
				}
				public Integer tconstLength(){
				    return 10;
				}
				public Integer tconstPrecision(){
				    return 0;
				}
				public String tconstDefault(){
				
					return null;
				
				}
				public String tconstComment(){
				
				    return "";
				
				}
				public String tconstPattern(){
				
					return "";
				
				}
				public String tconstOriginalDbColumnName(){
				
					return "tconst";
				
				}

				
			    public String primaryTitle;

				public String getPrimaryTitle () {
					return this.primaryTitle;
				}

				public Boolean primaryTitleIsNullable(){
				    return true;
				}
				public Boolean primaryTitleIsKey(){
				    return false;
				}
				public Integer primaryTitleLength(){
				    return 1024;
				}
				public Integer primaryTitlePrecision(){
				    return 0;
				}
				public String primaryTitleDefault(){
				
					return null;
				
				}
				public String primaryTitleComment(){
				
				    return "";
				
				}
				public String primaryTitlePattern(){
				
					return "";
				
				}
				public String primaryTitleOriginalDbColumnName(){
				
					return "primaryTitle";
				
				}

				
			    public java.util.Date DI_Create_DT;

				public java.util.Date getDI_Create_DT () {
					return this.DI_Create_DT;
				}

				public Boolean DI_Create_DTIsNullable(){
				    return false;
				}
				public Boolean DI_Create_DTIsKey(){
				    return false;
				}
				public Integer DI_Create_DTLength(){
				    return 19;
				}
				public Integer DI_Create_DTPrecision(){
				    return 0;
				}
				public String DI_Create_DTDefault(){
				
					return null;
				
				}
				public String DI_Create_DTComment(){
				
				    return "";
				
				}
				public String DI_Create_DTPattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String DI_Create_DTOriginalDbColumnName(){
				
					return "DI_Create_DT";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_dim_title.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_dim_title.length == 0) {
   					commonByteArray_FINAL_PROJECT_dim_title = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_dim_title = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_FINAL_PROJECT_dim_title, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_dim_title, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_dim_title.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_dim_title.length == 0) {
   					commonByteArray_FINAL_PROJECT_dim_title = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_dim_title = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_FINAL_PROJECT_dim_title, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_dim_title, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_dim_title) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.primaryTitle = readString(dis);
					
					this.DI_Create_DT = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_dim_title) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.primaryTitle = readString(dis);
					
					this.DI_Create_DT = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.tconst,dos);
					
					// String
				
						writeString(this.primaryTitle,dos);
					
					// java.util.Date
				
						writeDate(this.DI_Create_DT,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.tconst,dos);
					
					// String
				
						writeString(this.primaryTitle,dos);
					
					// java.util.Date
				
						writeDate(this.DI_Create_DT,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("tconst="+tconst);
		sb.append(",primaryTitle="+primaryTitle);
		sb.append(",DI_Create_DT="+String.valueOf(DI_Create_DT));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(tconst == null){
        					sb.append("<null>");
        				}else{
            				sb.append(tconst);
            			}
            		
        			sb.append("|");
        		
        				if(primaryTitle == null){
        					sb.append("<null>");
        				}else{
            				sb.append(primaryTitle);
            			}
            		
        			sb.append("|");
        		
        				if(DI_Create_DT == null){
        					sb.append("<null>");
        				}else{
            				sb.append(DI_Create_DT);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
    final static byte[] commonByteArrayLock_FINAL_PROJECT_dim_title = new byte[0];
    static byte[] commonByteArray_FINAL_PROJECT_dim_title = new byte[0];

	
			    public String tconst;

				public String getTconst () {
					return this.tconst;
				}

				public Boolean tconstIsNullable(){
				    return false;
				}
				public Boolean tconstIsKey(){
				    return false;
				}
				public Integer tconstLength(){
				    return 10;
				}
				public Integer tconstPrecision(){
				    return 0;
				}
				public String tconstDefault(){
				
					return null;
				
				}
				public String tconstComment(){
				
				    return "";
				
				}
				public String tconstPattern(){
				
					return "";
				
				}
				public String tconstOriginalDbColumnName(){
				
					return "tconst";
				
				}

				
			    public String primaryTitle;

				public String getPrimaryTitle () {
					return this.primaryTitle;
				}

				public Boolean primaryTitleIsNullable(){
				    return true;
				}
				public Boolean primaryTitleIsKey(){
				    return false;
				}
				public Integer primaryTitleLength(){
				    return 1024;
				}
				public Integer primaryTitlePrecision(){
				    return 0;
				}
				public String primaryTitleDefault(){
				
					return null;
				
				}
				public String primaryTitleComment(){
				
				    return "";
				
				}
				public String primaryTitlePattern(){
				
					return "";
				
				}
				public String primaryTitleOriginalDbColumnName(){
				
					return "primaryTitle";
				
				}

				
			    public java.util.Date DI_Create_DT;

				public java.util.Date getDI_Create_DT () {
					return this.DI_Create_DT;
				}

				public Boolean DI_Create_DTIsNullable(){
				    return false;
				}
				public Boolean DI_Create_DTIsKey(){
				    return false;
				}
				public Integer DI_Create_DTLength(){
				    return 19;
				}
				public Integer DI_Create_DTPrecision(){
				    return 0;
				}
				public String DI_Create_DTDefault(){
				
					return null;
				
				}
				public String DI_Create_DTComment(){
				
				    return "";
				
				}
				public String DI_Create_DTPattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String DI_Create_DTOriginalDbColumnName(){
				
					return "DI_CreatedDate";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_dim_title.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_dim_title.length == 0) {
   					commonByteArray_FINAL_PROJECT_dim_title = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_dim_title = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_FINAL_PROJECT_dim_title, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_dim_title, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_FINAL_PROJECT_dim_title.length) {
				if(length < 1024 && commonByteArray_FINAL_PROJECT_dim_title.length == 0) {
   					commonByteArray_FINAL_PROJECT_dim_title = new byte[1024];
				} else {
   					commonByteArray_FINAL_PROJECT_dim_title = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_FINAL_PROJECT_dim_title, 0, length);
			strReturn = new String(commonByteArray_FINAL_PROJECT_dim_title, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_dim_title) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.primaryTitle = readString(dis);
					
					this.DI_Create_DT = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_FINAL_PROJECT_dim_title) {

        	try {

        		int length = 0;
		
					this.tconst = readString(dis);
					
					this.primaryTitle = readString(dis);
					
					this.DI_Create_DT = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.tconst,dos);
					
					// String
				
						writeString(this.primaryTitle,dos);
					
					// java.util.Date
				
						writeDate(this.DI_Create_DT,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.tconst,dos);
					
					// String
				
						writeString(this.primaryTitle,dos);
					
					// java.util.Date
				
						writeDate(this.DI_Create_DT,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("tconst="+tconst);
		sb.append(",primaryTitle="+primaryTitle);
		sb.append(",DI_Create_DT="+String.valueOf(DI_Create_DT));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(tconst == null){
        					sb.append("<null>");
        				}else{
            				sb.append(tconst);
            			}
            		
        			sb.append("|");
        		
        				if(primaryTitle == null){
        					sb.append("<null>");
        				}else{
            				sb.append(primaryTitle);
            			}
            		
        			sb.append("|");
        		
        				if(DI_Create_DT == null){
        					sb.append("<null>");
        				}else{
            				sb.append(DI_Create_DT);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tDBInput_1");
		org.slf4j.MDC.put("_subJobPid", "HWXStc_" + subJobPidCounter.getAndIncrement());
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row1Struct row1 = new row1Struct();

		row2Struct row2 = new row2Struct();

			row3Struct row3 = new row3Struct();
toScdStruct toScd = new toScdStruct();





	
	/**
	 * [tDBSCD_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBSCD_1", false);
		start_Hash.put("tDBSCD_1", System.currentTimeMillis());
		
	
	currentComponent="tDBSCD_1";
	
	
			cLabel="\"dim_title\"";
		
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"toScd");
			
		int tos_count_tDBSCD_1 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tDBSCD_1", "\"dim_title\"", "tMysqlSCD");
				talendJobLogProcess(globalMap);
			}
			

    
    class CompareUtil_tDBSCD_1 {
        
        boolean scdEquals(java.util.Date d1, java.util.Date d2) {
            if(d1!=null && d2!=null) {
                return java.lang.Math.abs(d1.getTime() - d2.getTime()) <= 999;
            }
            return d1 == d2;
        }
         
    }
    
    CompareUtil_tDBSCD_1 cu_tDBSCD_1 = new CompareUtil_tDBSCD_1();
    
        class SCDSK_tDBSCD_1 {
private int hashCode;
public boolean hashCodeDirty = true;
String tconst;
public boolean equals(Object obj) {
if (this == obj) return true;
if (obj == null) return false;
if (getClass() != obj.getClass()) return false;
final SCDSK_tDBSCD_1 other = (SCDSK_tDBSCD_1) obj;
if (this.tconst == null) {
if (other.tconst!= null)
return false;
} else if (!this.tconst.equals(other.tconst))
return false;

return true;
}
public int hashCode() {
if(hashCodeDirty) {
int prime = 31;hashCode = prime * hashCode + (tconst == null ? 0 : tconst.hashCode());
hashCodeDirty = false;
}
return hashCode;
}
}

    class SCDStruct_tDBSCD_1 {
private String DI_WorkflowJobId;
private java.util.Date DI_CreatedDate;
private String Title;
}

    int nb_line_update_tDBSCD_1 = 0;
    int nb_line_inserted_tDBSCD_1 = 0;
    int nb_line_rejected_tDBSCD_1 = 0;
    String tableName_tDBSCD_1 = "dim_title";
        java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
       
        String properties_tDBSCD_1 = context.MySqlLocal_AdditionalParams;
        if (properties_tDBSCD_1 == null || properties_tDBSCD_1.trim().length() == 0) {
            properties_tDBSCD_1 = "";
        }
        String url_tDBSCD_1 = "jdbc:mysql://" + context.MySqlLocal_Server + ":" + context.MySqlLocal_Port + "/" + context.MySqlLocal_Database + "?" + properties_tDBSCD_1;
	        
		
		
		
	final String decryptedPassword_tDBSCD_1 = context.MySqlLocal_Password; 
	   	
        java.sql.Connection connection_tDBSCD_1 = java.sql.DriverManager.getConnection(url_tDBSCD_1, context.MySqlLocal_Login, decryptedPassword_tDBSCD_1);
    
			java.sql.DatabaseMetaData dbMetaData_tDBSCD_1 = connection_tDBSCD_1.getMetaData();
                    java.sql.ResultSet rsTable_tDBSCD_1 = dbMetaData_tDBSCD_1.getTables(context.MySqlLocal_Database, null, null, new String[]{"TABLE"});
                boolean whetherExist_tDBSCD_1 = false;
                while(rsTable_tDBSCD_1.next()) {
                    String table_tDBSCD_1 = rsTable_tDBSCD_1.getString("TABLE_NAME");
                    if(table_tDBSCD_1.equalsIgnoreCase("dim_title")) {
                        whetherExist_tDBSCD_1 = true;
                        break;
                    }
                }            
            if(!whetherExist_tDBSCD_1) {
                java.sql.Statement stmtCreate_tDBSCD_1 = connection_tDBSCD_1.createStatement();
                stmtCreate_tDBSCD_1.execute("CREATE TABLE `" + tableName_tDBSCD_1 + "`(`tconst` VARCHAR(10)  ,`Title` VARCHAR(1024)  ,`scd_start` DATETIME ,`DI_CreatedDate` DATETIME ,`DI_WorkflowJobId` VARCHAR(8)  ,`scd_end` DATETIME ,`Title_SK` INT(0)  AUTO_INCREMENT  not null ,primary key(`Title_SK`))");
                stmtCreate_tDBSCD_1.close();
            }
        
    java.util.Calendar calendar_tDBSCD_1 = java.util.Calendar.getInstance();
    java.util.Calendar calendarYear0_tDBSCD_1 = java.util.Calendar.getInstance();
    
    calendar_tDBSCD_1.set(1, 0, 1, 0, 0, 0);
    calendarYear0_tDBSCD_1.set(0,0,0,0,0,0);
    
    final java.util.Date dateYear0_tDBSCD_1 = calendarYear0_tDBSCD_1.getTime();
    final long year1_tDBSCD_1 = calendar_tDBSCD_1.getTime().getTime();
    
    
    calendar_tDBSCD_1.set(10000, 0, 1, 0, 0, 0);
    final long year10000_tDBSCD_1 = calendar_tDBSCD_1.getTime().getTime();
    long date_tDBSCD_1 = 0;    
    String dateStr_tDBSCD_1 = null;
    String tmpValue_tDBSCD_1 = null;    
        String search_tDBSCD_1 = "SELECT `tconst`, `DI_WorkflowJobId`, `DI_CreatedDate`, `Title` FROM `" + tableName_tDBSCD_1 + "` WHERE `scd_end` IS NULL";
        java.sql.Statement statement_tDBSCD_1 = connection_tDBSCD_1.createStatement();
        java.sql.ResultSet resultSet_tDBSCD_1 = statement_tDBSCD_1.executeQuery(search_tDBSCD_1);
        java.util.Map<SCDSK_tDBSCD_1, SCDStruct_tDBSCD_1> cache_tDBSCD_1 = new java.util.HashMap<SCDSK_tDBSCD_1, SCDStruct_tDBSCD_1>();
        while(resultSet_tDBSCD_1.next()) {
            SCDSK_tDBSCD_1 sk_tDBSCD_1 = new SCDSK_tDBSCD_1();
            SCDStruct_tDBSCD_1 row_tDBSCD_1 = new SCDStruct_tDBSCD_1();
                    if(resultSet_tDBSCD_1.getObject(1) != null) {
                        sk_tDBSCD_1.tconst = resultSet_tDBSCD_1.getString(1);
                    }
                    if(resultSet_tDBSCD_1.getObject(2) != null) {
                        row_tDBSCD_1.DI_WorkflowJobId = resultSet_tDBSCD_1.getString(2);
                    }
                    dateStr_tDBSCD_1 = resultSet_tDBSCD_1.getString(3);
                    if(dateStr_tDBSCD_1 != null) {
                        if(!("0000-00-00").equals(dateStr_tDBSCD_1) && !("0000-00-00 00:00:00").equals(dateStr_tDBSCD_1)) {
                            row_tDBSCD_1.DI_CreatedDate = new java.util.Date(resultSet_tDBSCD_1.getTimestamp(3).getTime());
                        } else {
                            row_tDBSCD_1.DI_CreatedDate = (java.util.Date) dateYear0_tDBSCD_1.clone();
                        }
                    } else {
                        row_tDBSCD_1.DI_CreatedDate = null;
                    }
                    if(resultSet_tDBSCD_1.getObject(4) != null) {
                        row_tDBSCD_1.Title = resultSet_tDBSCD_1.getString(4);
                    }
            cache_tDBSCD_1.put(sk_tDBSCD_1, row_tDBSCD_1);
        }
        resultSet_tDBSCD_1.close();
        statement_tDBSCD_1.close();
    String insertionSQL_tDBSCD_1 = "INSERT INTO `" + tableName_tDBSCD_1 + "`(`tconst`, `DI_WorkflowJobId`, `DI_CreatedDate`, `Title`, `scd_start`, `scd_end`) VALUES(?, ?, ?, ?, ?, ?)";
    java.sql.PreparedStatement insertionStatement_tDBSCD_1 = connection_tDBSCD_1.prepareStatement(insertionSQL_tDBSCD_1);
            insertionStatement_tDBSCD_1.setNull(6, java.sql.Types.DATE);
        String updateSQLForType1_tDBSCD_1 = "UPDATE `" + tableName_tDBSCD_1 + "` SET `DI_WorkflowJobId` = ?, `DI_CreatedDate` = ? WHERE `tconst` = ?";
        java.sql.PreparedStatement updateForType1_tDBSCD_1 = connection_tDBSCD_1.prepareStatement(updateSQLForType1_tDBSCD_1);        
        String updateSQLForType2_tDBSCD_1 = "UPDATE `" + tableName_tDBSCD_1 + "` SET `scd_end` = ? WHERE `tconst` = ? AND `scd_end` IS NULL";
        java.sql.PreparedStatement updateForType2_tDBSCD_1 = connection_tDBSCD_1.prepareStatement(updateSQLForType2_tDBSCD_1);
    
        SCDSK_tDBSCD_1 lookUpKey_tDBSCD_1 = null;        
    SCDStruct_tDBSCD_1 lookUpValue_tDBSCD_1 = null;

 



/**
 * [tDBSCD_1 begin ] stop
 */



	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_1", false);
		start_Hash.put("tMap_1", System.currentTimeMillis());
		
	
	currentComponent="tMap_1";
	
	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row3");
			
		int tos_count_tMap_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tMap_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tMap_1 = new StringBuilder();
                    log4jParamters_tMap_1.append("Parameters:");
                            log4jParamters_tMap_1.append("LINK_STYLE" + " = " + "AUTO");
                        log4jParamters_tMap_1.append(" | ");
                            log4jParamters_tMap_1.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
                        log4jParamters_tMap_1.append(" | ");
                            log4jParamters_tMap_1.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
                        log4jParamters_tMap_1.append(" | ");
                            log4jParamters_tMap_1.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
                        log4jParamters_tMap_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + (log4jParamters_tMap_1) );
                    } 
                } 
            new BytesLimit65535_tMap_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tMap_1", "tMap_1", "tMap");
				talendJobLogProcess(globalMap);
			}
			




// ###############################
// # Lookup's keys initialization
		int count_row3_tMap_1 = 0;
		
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_toScd_tMap_1 = 0;
				
toScdStruct toScd_tmp = new toScdStruct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
 */



	
	/**
	 * [tUnite_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tUnite_1", false);
		start_Hash.put("tUnite_1", System.currentTimeMillis());
		
	
	currentComponent="tUnite_1";
	
	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row1","row2");
			
		int tos_count_tUnite_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tUnite_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tUnite_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tUnite_1 = new StringBuilder();
                    log4jParamters_tUnite_1.append("Parameters:");
                if(log.isDebugEnabled())
            log.debug("tUnite_1 - "  + (log4jParamters_tUnite_1) );
                    } 
                } 
            new BytesLimit65535_tUnite_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tUnite_1", "tUnite_1", "tUnite");
				talendJobLogProcess(globalMap);
			}
			

int nb_line_tUnite_1 = 0;

 



/**
 * [tUnite_1 begin ] stop
 */
	
	/**
	 * [tDBInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_1", false);
		start_Hash.put("tDBInput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_1";
	
	
			cLabel="stg_movie_details";
		
		int tos_count_tDBInput_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBInput_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBInput_1 = new StringBuilder();
                    log4jParamters_tDBInput_1.append("Parameters:");
                            log4jParamters_tDBInput_1.append("DB_VERSION" + " = " + "MYSQL_8");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("HOST" + " = " + "context.MySqlLocal_Server");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("PORT" + " = " + "context.MySqlLocal_Port");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("DBNAME" + " = " + "context.MySqlLocal_Database");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("USER" + " = " + "context.MySqlLocal_Login");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("PASS" + " = " + String.valueOf(routines.system.PasswordEncryptUtil.encryptPassword(context.MySqlLocal_Password)).substring(0, 4) + "...");     
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TABLE" + " = " + "\"stg_movie_details\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("QUERY" + " = " + "\"SELECT tconst, primaryTitle, DI_Create_DT  FROM stg_movie_details;\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("PROPERTIES" + " = " + "context.MySqlLocal_AdditionalParams");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("ENABLE_STREAM" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("tconst")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("primaryTitle")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("DI_Create_DT")+"}]");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
                        log4jParamters_tDBInput_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + (log4jParamters_tDBInput_1) );
                    } 
                } 
            new BytesLimit65535_tDBInput_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBInput_1", "stg_movie_details", "tMysqlInput");
				talendJobLogProcess(globalMap);
			}
			
	
	
		    java.util.Calendar calendar_tDBInput_1 = java.util.Calendar.getInstance();
		    calendar_tDBInput_1.set(0, 0, 0, 0, 0, 0);
		    java.util.Date year0_tDBInput_1 = calendar_tDBInput_1.getTime();
		    int nb_line_tDBInput_1 = 0;
		    java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "com.mysql.cj.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = context.MySqlLocal_Login;
				
				
	final String decryptedPassword_tDBInput_1 = context.MySqlLocal_Password; 
				
				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;
				
        String properties_tDBInput_1 = context.MySqlLocal_AdditionalParams;
        if (properties_tDBInput_1 == null || properties_tDBInput_1.trim().length() == 0) {
            properties_tDBInput_1 = "";
        }
        String url_tDBInput_1 = "jdbc:mysql://" + context.MySqlLocal_Server + ":" + context.MySqlLocal_Port + "/" + context.MySqlLocal_Database + "?" + properties_tDBInput_1;
				
	    		log.debug("tDBInput_1 - Driver ClassName: "+driverClass_tDBInput_1+".");
			
	    		log.debug("tDBInput_1 - Connection attempt to '" + url_tDBInput_1 + "' with the username '" + dbUser_tDBInput_1 + "'.");
			
				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1,dbUser_tDBInput_1,dbPwd_tDBInput_1);
	    		log.debug("tDBInput_1 - Connection to '" + url_tDBInput_1 + "' has succeeded.");
			
		        
		    
			java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

		    String dbquery_tDBInput_1 = "SELECT tconst, primaryTitle, DI_Create_DT  FROM stg_movie_details;";
		    
	    		log.debug("tDBInput_1 - Executing the query: '" + dbquery_tDBInput_1 + "'.");
			

		    globalMap.put("tDBInput_1_QUERY",dbquery_tDBInput_1);

		    java.sql.ResultSet rs_tDBInput_1 = null;

		    try {
		    	rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
		    	int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

		    String tmpContent_tDBInput_1 = null;
		    
		    
		    	log.debug("tDBInput_1 - Retrieving records from the database.");
		    
		    while (rs_tDBInput_1.next()) {
		        nb_line_tDBInput_1++;
		        
							if(colQtyInRs_tDBInput_1 < 1) {
								row1.tconst = null;
							} else {
	                         		
        	row1.tconst = routines.system.JDBCUtil.getString(rs_tDBInput_1, 1, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.primaryTitle = null;
							} else {
	                         		
        	row1.primaryTitle = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.DI_Create_DT = null;
							} else {
										
				if(rs_tDBInput_1.getString(3) != null) {
					String dateString_tDBInput_1 = rs_tDBInput_1.getString(3);
					if (!("0000-00-00").equals(dateString_tDBInput_1) && !("0000-00-00 00:00:00").equals(dateString_tDBInput_1)) {
						row1.DI_Create_DT = rs_tDBInput_1.getTimestamp(3);
					} else {
						row1.DI_Create_DT = (java.util.Date) year0_tDBInput_1.clone();
					}
				} else {
					row1.DI_Create_DT =  null;
				}
		                    }
					
						log.debug("tDBInput_1 - Retrieving the record " + nb_line_tDBInput_1 + ".");
					

 



/**
 * [tDBInput_1 begin ] stop
 */
	
	/**
	 * [tDBInput_1 main ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="stg_movie_details";
		

 


	tos_count_tDBInput_1++;

/**
 * [tDBInput_1 main ] stop
 */
	
	/**
	 * [tDBInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="stg_movie_details";
		

 



/**
 * [tDBInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tUnite_1 main ] start
	 */

	

	
	
	currentComponent="tUnite_1";
	
	
					if(runStat.update(execStat,enableLogStash,iterateId,1,1
						
							,"row1","tDBInput_1","stg_movie_details","tMysqlInput","tUnite_1","tUnite_1","tUnite"
							
					)) {
						talendJobLogProcess(globalMap);
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("row1 - " + (row1==null? "": row1.toLogString()));
    			}
    		
    			if(log.isTraceEnabled()){
    				log.trace("row2 - " + (row2==null? "": row2.toLogString()));
    			}
    		
//////////
 

// for output
			row3 = new row3Struct();
								
			row3.tconst = row1.tconst;								
			row3.primaryTitle = row1.primaryTitle;								
			row3.DI_Create_DT = row1.DI_Create_DT;			

			nb_line_tUnite_1++;

//////////
 


	tos_count_tUnite_1++;

/**
 * [tUnite_1 main ] stop
 */
	
	/**
	 * [tUnite_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tUnite_1";
	
	

 



/**
 * [tUnite_1 process_data_begin ] stop
 */

	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row3","tUnite_1","tUnite_1","tUnite","tMap_1","tMap_1","tMap"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row3 - " + (row3==null? "": row3.toLogString()));
    			}
    		

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		
		// ###############################
		// # Input tables (lookups)
		
		boolean rejectedInnerJoin_tMap_1 = false;
		boolean mainRowRejected_tMap_1 = false;
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

toScd = null;


// # Output table : 'toScd'
count_toScd_tMap_1++;

toScd_tmp.tconst = row3.tconst;
toScd_tmp.Title = row3.primaryTitle;
toScd_tmp.scd_start = row3.DI_Create_DT;
toScd_tmp.DI_CreatedDate = TalendDate.getCurrentDate();
toScd_tmp.DI_WorkflowJobId = pid;
toScd = toScd_tmp;
log.debug("tMap_1 - Outputting the record " + count_toScd_tMap_1 + " of the output table 'toScd'.");

// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_1 = false;










 


	tos_count_tMap_1++;

/**
 * [tMap_1 main ] stop
 */
	
	/**
	 * [tMap_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	

 



/**
 * [tMap_1 process_data_begin ] stop
 */
// Start of branch "toScd"
if(toScd != null) { 



	
	/**
	 * [tDBSCD_1 main ] start
	 */

	

	
	
	currentComponent="tDBSCD_1";
	
	
			cLabel="\"dim_title\"";
		
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"toScd","tMap_1","tMap_1","tMap","tDBSCD_1","\"dim_title\"","tMysqlSCD"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("toScd - " + (toScd==null? "": toScd.toLogString()));
    			}
    		

	try {
        lookUpKey_tDBSCD_1 = new SCDSK_tDBSCD_1();
            lookUpKey_tDBSCD_1.tconst = toScd.tconst;
        lookUpKey_tDBSCD_1.hashCodeDirty = true;
        lookUpValue_tDBSCD_1 = cache_tDBSCD_1.get(lookUpKey_tDBSCD_1);    
    if(lookUpValue_tDBSCD_1 == null) {
            lookUpValue_tDBSCD_1 = new SCDStruct_tDBSCD_1();
        
                    if(toScd.tconst == null) {
insertionStatement_tDBSCD_1.setNull(1, java.sql.Types.VARCHAR);
} else {
insertionStatement_tDBSCD_1.setString(1, toScd.tconst);
}

                    if(toScd.DI_WorkflowJobId == null) {
insertionStatement_tDBSCD_1.setNull(2, java.sql.Types.VARCHAR);
} else {
insertionStatement_tDBSCD_1.setString(2, toScd.DI_WorkflowJobId);
}

                    if(toScd.DI_CreatedDate == null) {
insertionStatement_tDBSCD_1.setNull(3, java.sql.Types.DATE);
} else {
if(toScd.DI_CreatedDate != null) {
date_tDBSCD_1 = toScd.DI_CreatedDate.getTime();
if(date_tDBSCD_1 < year1_tDBSCD_1 || date_tDBSCD_1 >= year10000_tDBSCD_1) {
insertionStatement_tDBSCD_1.setString(3, "0000-00-00 00:00:00");
} else {
insertionStatement_tDBSCD_1.setTimestamp(3, new java.sql.Timestamp(date_tDBSCD_1));
}
} else {
insertionStatement_tDBSCD_1.setNull(3, java.sql.Types.DATE);
}
}

                    if(toScd.Title == null) {
insertionStatement_tDBSCD_1.setNull(4, java.sql.Types.VARCHAR);
} else {
insertionStatement_tDBSCD_1.setString(4, toScd.Title);
}

                    if(toScd.scd_start == null) {
insertionStatement_tDBSCD_1.setNull(5, java.sql.Types.DATE);
} else {
if(toScd.scd_start != null) {
date_tDBSCD_1 = toScd.scd_start.getTime();
if(date_tDBSCD_1 < year1_tDBSCD_1 || date_tDBSCD_1 >= year10000_tDBSCD_1) {
insertionStatement_tDBSCD_1.setString(5, "0000-00-00 00:00:00");
} else {
insertionStatement_tDBSCD_1.setTimestamp(5, new java.sql.Timestamp(date_tDBSCD_1));
}
} else {
insertionStatement_tDBSCD_1.setNull(5, java.sql.Types.DATE);
}
}

        nb_line_inserted_tDBSCD_1 += insertionStatement_tDBSCD_1.executeUpdate();
    } else {
            if((lookUpValue_tDBSCD_1.DI_WorkflowJobId == null && toScd.DI_WorkflowJobId!= null) || (lookUpValue_tDBSCD_1.DI_WorkflowJobId != null && !lookUpValue_tDBSCD_1.DI_WorkflowJobId.equals(toScd.DI_WorkflowJobId)) || !cu_tDBSCD_1.scdEquals(lookUpValue_tDBSCD_1.DI_CreatedDate,toScd.DI_CreatedDate)) {
                    if(toScd.DI_WorkflowJobId == null) {
updateForType1_tDBSCD_1.setNull(1, java.sql.Types.VARCHAR);
} else {
updateForType1_tDBSCD_1.setString(1, toScd.DI_WorkflowJobId);
}

                    if(toScd.DI_CreatedDate == null) {
updateForType1_tDBSCD_1.setNull(2, java.sql.Types.DATE);
} else {
if(toScd.DI_CreatedDate != null) {
date_tDBSCD_1 = toScd.DI_CreatedDate.getTime();
if(date_tDBSCD_1 < year1_tDBSCD_1 || date_tDBSCD_1 >= year10000_tDBSCD_1) {
updateForType1_tDBSCD_1.setString(2, "0000-00-00 00:00:00");
} else {
updateForType1_tDBSCD_1.setTimestamp(2, new java.sql.Timestamp(date_tDBSCD_1));
}
} else {
updateForType1_tDBSCD_1.setNull(2, java.sql.Types.DATE);
}
}

                    if(toScd.tconst == null) {
updateForType1_tDBSCD_1.setNull(3, java.sql.Types.VARCHAR);
} else {
updateForType1_tDBSCD_1.setString(3, toScd.tconst);
}

                nb_line_update_tDBSCD_1 += updateForType1_tDBSCD_1.executeUpdate();
            }
            if((lookUpValue_tDBSCD_1.Title == null && toScd.Title!= null) || (lookUpValue_tDBSCD_1.Title != null && !lookUpValue_tDBSCD_1.Title.equals(toScd.Title))) {
                    if(toScd.scd_start == null) {
updateForType2_tDBSCD_1.setNull(1, java.sql.Types.DATE);
} else {
if(toScd.scd_start != null) {
date_tDBSCD_1 = toScd.scd_start.getTime();
if(date_tDBSCD_1 < year1_tDBSCD_1 || date_tDBSCD_1 >= year10000_tDBSCD_1) {
updateForType2_tDBSCD_1.setString(1, "0000-00-00 00:00:00");
} else {
updateForType2_tDBSCD_1.setTimestamp(1, new java.sql.Timestamp(date_tDBSCD_1));
}
} else {
updateForType2_tDBSCD_1.setNull(1, java.sql.Types.DATE);
}
}

                    if(toScd.tconst == null) {
updateForType2_tDBSCD_1.setNull(2, java.sql.Types.VARCHAR);
} else {
updateForType2_tDBSCD_1.setString(2, toScd.tconst);
}

                nb_line_update_tDBSCD_1 += updateForType2_tDBSCD_1.executeUpdate();
                            if(toScd.tconst == null) {
insertionStatement_tDBSCD_1.setNull(1, java.sql.Types.VARCHAR);
} else {
insertionStatement_tDBSCD_1.setString(1, toScd.tconst);
}

                            if(toScd.DI_WorkflowJobId == null) {
insertionStatement_tDBSCD_1.setNull(2, java.sql.Types.VARCHAR);
} else {
insertionStatement_tDBSCD_1.setString(2, toScd.DI_WorkflowJobId);
}

                            if(toScd.DI_CreatedDate == null) {
insertionStatement_tDBSCD_1.setNull(3, java.sql.Types.DATE);
} else {
if(toScd.DI_CreatedDate != null) {
date_tDBSCD_1 = toScd.DI_CreatedDate.getTime();
if(date_tDBSCD_1 < year1_tDBSCD_1 || date_tDBSCD_1 >= year10000_tDBSCD_1) {
insertionStatement_tDBSCD_1.setString(3, "0000-00-00 00:00:00");
} else {
insertionStatement_tDBSCD_1.setTimestamp(3, new java.sql.Timestamp(date_tDBSCD_1));
}
} else {
insertionStatement_tDBSCD_1.setNull(3, java.sql.Types.DATE);
}
}

                            if(toScd.Title == null) {
insertionStatement_tDBSCD_1.setNull(4, java.sql.Types.VARCHAR);
} else {
insertionStatement_tDBSCD_1.setString(4, toScd.Title);
}

                            if(toScd.scd_start == null) {
insertionStatement_tDBSCD_1.setNull(5, java.sql.Types.DATE);
} else {
if(toScd.scd_start != null) {
date_tDBSCD_1 = toScd.scd_start.getTime();
if(date_tDBSCD_1 < year1_tDBSCD_1 || date_tDBSCD_1 >= year10000_tDBSCD_1) {
insertionStatement_tDBSCD_1.setString(5, "0000-00-00 00:00:00");
} else {
insertionStatement_tDBSCD_1.setTimestamp(5, new java.sql.Timestamp(date_tDBSCD_1));
}
} else {
insertionStatement_tDBSCD_1.setNull(5, java.sql.Types.DATE);
}
}

                nb_line_inserted_tDBSCD_1 += insertionStatement_tDBSCD_1.executeUpdate();
            }
    }
    
	} catch (java.lang.Exception e) {//catch
globalMap.put("tDBSCD_1_ERROR_MESSAGE",e.getMessage());
  		
                System.err.print(e.getMessage());
	}//end catch
                lookUpValue_tDBSCD_1.DI_WorkflowJobId = toScd.DI_WorkflowJobId;
                lookUpValue_tDBSCD_1.DI_CreatedDate = toScd.DI_CreatedDate;
                lookUpValue_tDBSCD_1.Title = toScd.Title;
        cache_tDBSCD_1.put(lookUpKey_tDBSCD_1, lookUpValue_tDBSCD_1);

 


	tos_count_tDBSCD_1++;

/**
 * [tDBSCD_1 main ] stop
 */
	
	/**
	 * [tDBSCD_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBSCD_1";
	
	
			cLabel="\"dim_title\"";
		

 



/**
 * [tDBSCD_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBSCD_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBSCD_1";
	
	
			cLabel="\"dim_title\"";
		

 



/**
 * [tDBSCD_1 process_data_end ] stop
 */

} // End of branch "toScd"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	

 



/**
 * [tMap_1 process_data_end ] stop
 */



	
	/**
	 * [tUnite_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUnite_1";
	
	

 



/**
 * [tUnite_1 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="stg_movie_details";
		

 



/**
 * [tDBInput_1 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_1 end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="stg_movie_details";
		

	}
}finally{
	if (rs_tDBInput_1 != null) {
		rs_tDBInput_1.close();
	}
	if (stmt_tDBInput_1 != null) {
		stmt_tDBInput_1.close();
	}
		if(conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {
			
	    		log.debug("tDBInput_1 - Closing the connection to the database.");
			
			conn_tDBInput_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	    		log.debug("tDBInput_1 - Connection to the database closed.");
			
		}
		
}
globalMap.put("tDBInput_1_NB_LINE",nb_line_tDBInput_1);
	    		log.debug("tDBInput_1 - Retrieved records count: "+nb_line_tDBInput_1 + " .");
			

 
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + ("Done.") );

ok_Hash.put("tDBInput_1", true);
end_Hash.put("tDBInput_1", System.currentTimeMillis());




/**
 * [tDBInput_1 end ] stop
 */
	
	/**
	 * [tDBInput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_2", false);
		start_Hash.put("tDBInput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_2";
	
	
			cLabel="stg_movie_details_v2";
		
		int tos_count_tDBInput_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBInput_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBInput_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBInput_2 = new StringBuilder();
                    log4jParamters_tDBInput_2.append("Parameters:");
                            log4jParamters_tDBInput_2.append("DB_VERSION" + " = " + "MYSQL_8");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("USE_EXISTING_CONNECTION" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("HOST" + " = " + "context.MySqlLocal_Server");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("PORT" + " = " + "context.MySqlLocal_Port");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("DBNAME" + " = " + "context.MySqlLocal_Database");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("USER" + " = " + "context.MySqlLocal_Login");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("PASS" + " = " + String.valueOf(routines.system.PasswordEncryptUtil.encryptPassword(context.MySqlLocal_Password)).substring(0, 4) + "...");     
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("TABLE" + " = " + "\"stg_movie_details\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("QUERY" + " = " + "\"SELECT tconst, primaryTitle, DI_CreatedDate AS DI_Create_DT FROM new_title_basics;\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("PROPERTIES" + " = " + "context.MySqlLocal_AdditionalParams");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("ENABLE_STREAM" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("tconst")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("primaryTitle")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("DI_Create_DT")+"}]");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
                        log4jParamters_tDBInput_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBInput_2 - "  + (log4jParamters_tDBInput_2) );
                    } 
                } 
            new BytesLimit65535_tDBInput_2().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBInput_2", "stg_movie_details_v2", "tMysqlInput");
				talendJobLogProcess(globalMap);
			}
			
	
	
		    java.util.Calendar calendar_tDBInput_2 = java.util.Calendar.getInstance();
		    calendar_tDBInput_2.set(0, 0, 0, 0, 0, 0);
		    java.util.Date year0_tDBInput_2 = calendar_tDBInput_2.getTime();
		    int nb_line_tDBInput_2 = 0;
		    java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "com.mysql.cj.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_2 = java.lang.Class.forName(driverClass_tDBInput_2);
				String dbUser_tDBInput_2 = context.MySqlLocal_Login;
				
				
	final String decryptedPassword_tDBInput_2 = context.MySqlLocal_Password; 
				
				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;
				
        String properties_tDBInput_2 = context.MySqlLocal_AdditionalParams;
        if (properties_tDBInput_2 == null || properties_tDBInput_2.trim().length() == 0) {
            properties_tDBInput_2 = "";
        }
        String url_tDBInput_2 = "jdbc:mysql://" + context.MySqlLocal_Server + ":" + context.MySqlLocal_Port + "/" + context.MySqlLocal_Database + "?" + properties_tDBInput_2;
				
	    		log.debug("tDBInput_2 - Driver ClassName: "+driverClass_tDBInput_2+".");
			
	    		log.debug("tDBInput_2 - Connection attempt to '" + url_tDBInput_2 + "' with the username '" + dbUser_tDBInput_2 + "'.");
			
				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2,dbUser_tDBInput_2,dbPwd_tDBInput_2);
	    		log.debug("tDBInput_2 - Connection to '" + url_tDBInput_2 + "' has succeeded.");
			
		        
		    
			java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

		    String dbquery_tDBInput_2 = "SELECT tconst, primaryTitle, DI_CreatedDate AS DI_Create_DT FROM new_title_basics;";
		    
	    		log.debug("tDBInput_2 - Executing the query: '" + dbquery_tDBInput_2 + "'.");
			

		    globalMap.put("tDBInput_2_QUERY",dbquery_tDBInput_2);

		    java.sql.ResultSet rs_tDBInput_2 = null;

		    try {
		    	rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
		    	int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

		    String tmpContent_tDBInput_2 = null;
		    
		    
		    	log.debug("tDBInput_2 - Retrieving records from the database.");
		    
		    while (rs_tDBInput_2.next()) {
		        nb_line_tDBInput_2++;
		        
							if(colQtyInRs_tDBInput_2 < 1) {
								row2.tconst = null;
							} else {
	                         		
        	row2.tconst = routines.system.JDBCUtil.getString(rs_tDBInput_2, 1, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								row2.primaryTitle = null;
							} else {
	                         		
        	row2.primaryTitle = routines.system.JDBCUtil.getString(rs_tDBInput_2, 2, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								row2.DI_Create_DT = null;
							} else {
										
				if(rs_tDBInput_2.getString(3) != null) {
					String dateString_tDBInput_2 = rs_tDBInput_2.getString(3);
					if (!("0000-00-00").equals(dateString_tDBInput_2) && !("0000-00-00 00:00:00").equals(dateString_tDBInput_2)) {
						row2.DI_Create_DT = rs_tDBInput_2.getTimestamp(3);
					} else {
						row2.DI_Create_DT = (java.util.Date) year0_tDBInput_2.clone();
					}
				} else {
					row2.DI_Create_DT =  null;
				}
		                    }
					
						log.debug("tDBInput_2 - Retrieving the record " + nb_line_tDBInput_2 + ".");
					

 



/**
 * [tDBInput_2 begin ] stop
 */
	
	/**
	 * [tDBInput_2 main ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	
			cLabel="stg_movie_details_v2";
		

 


	tos_count_tDBInput_2++;

/**
 * [tDBInput_2 main ] stop
 */
	
	/**
	 * [tDBInput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	
			cLabel="stg_movie_details_v2";
		

 



/**
 * [tDBInput_2 process_data_begin ] stop
 */

	
	/**
	 * [tUnite_1 main ] start
	 */

	

	
	
	currentComponent="tUnite_1";
	
	
					if(runStat.update(execStat,enableLogStash,iterateId,1,1
						
							,"row2","tDBInput_2","stg_movie_details_v2","tMysqlInput","tUnite_1","tUnite_1","tUnite"
							
					)) {
						talendJobLogProcess(globalMap);
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("row1 - " + (row1==null? "": row1.toLogString()));
    			}
    		
    			if(log.isTraceEnabled()){
    				log.trace("row2 - " + (row2==null? "": row2.toLogString()));
    			}
    		
//////////
 

// for output
			row3 = new row3Struct();
								
			row3.tconst = row2.tconst;								
			row3.primaryTitle = row2.primaryTitle;								
			row3.DI_Create_DT = row2.DI_Create_DT;			

			nb_line_tUnite_1++;

//////////
 


	tos_count_tUnite_1++;

/**
 * [tUnite_1 main ] stop
 */
	
	/**
	 * [tUnite_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tUnite_1";
	
	

 



/**
 * [tUnite_1 process_data_begin ] stop
 */

	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row3","tUnite_1","tUnite_1","tUnite","tMap_1","tMap_1","tMap"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row3 - " + (row3==null? "": row3.toLogString()));
    			}
    		

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		
		// ###############################
		// # Input tables (lookups)
		
		boolean rejectedInnerJoin_tMap_1 = false;
		boolean mainRowRejected_tMap_1 = false;
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

toScd = null;


// # Output table : 'toScd'
count_toScd_tMap_1++;

toScd_tmp.tconst = row3.tconst;
toScd_tmp.Title = row3.primaryTitle;
toScd_tmp.scd_start = row3.DI_Create_DT;
toScd_tmp.DI_CreatedDate = TalendDate.getCurrentDate();
toScd_tmp.DI_WorkflowJobId = pid;
toScd = toScd_tmp;
log.debug("tMap_1 - Outputting the record " + count_toScd_tMap_1 + " of the output table 'toScd'.");

// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_1 = false;










 


	tos_count_tMap_1++;

/**
 * [tMap_1 main ] stop
 */
	
	/**
	 * [tMap_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	

 



/**
 * [tMap_1 process_data_begin ] stop
 */
// Start of branch "toScd"
if(toScd != null) { 



	
	/**
	 * [tDBSCD_1 main ] start
	 */

	

	
	
	currentComponent="tDBSCD_1";
	
	
			cLabel="\"dim_title\"";
		
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"toScd","tMap_1","tMap_1","tMap","tDBSCD_1","\"dim_title\"","tMysqlSCD"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("toScd - " + (toScd==null? "": toScd.toLogString()));
    			}
    		

	try {
        lookUpKey_tDBSCD_1 = new SCDSK_tDBSCD_1();
            lookUpKey_tDBSCD_1.tconst = toScd.tconst;
        lookUpKey_tDBSCD_1.hashCodeDirty = true;
        lookUpValue_tDBSCD_1 = cache_tDBSCD_1.get(lookUpKey_tDBSCD_1);    
    if(lookUpValue_tDBSCD_1 == null) {
            lookUpValue_tDBSCD_1 = new SCDStruct_tDBSCD_1();
        
                    if(toScd.tconst == null) {
insertionStatement_tDBSCD_1.setNull(1, java.sql.Types.VARCHAR);
} else {
insertionStatement_tDBSCD_1.setString(1, toScd.tconst);
}

                    if(toScd.DI_WorkflowJobId == null) {
insertionStatement_tDBSCD_1.setNull(2, java.sql.Types.VARCHAR);
} else {
insertionStatement_tDBSCD_1.setString(2, toScd.DI_WorkflowJobId);
}

                    if(toScd.DI_CreatedDate == null) {
insertionStatement_tDBSCD_1.setNull(3, java.sql.Types.DATE);
} else {
if(toScd.DI_CreatedDate != null) {
date_tDBSCD_1 = toScd.DI_CreatedDate.getTime();
if(date_tDBSCD_1 < year1_tDBSCD_1 || date_tDBSCD_1 >= year10000_tDBSCD_1) {
insertionStatement_tDBSCD_1.setString(3, "0000-00-00 00:00:00");
} else {
insertionStatement_tDBSCD_1.setTimestamp(3, new java.sql.Timestamp(date_tDBSCD_1));
}
} else {
insertionStatement_tDBSCD_1.setNull(3, java.sql.Types.DATE);
}
}

                    if(toScd.Title == null) {
insertionStatement_tDBSCD_1.setNull(4, java.sql.Types.VARCHAR);
} else {
insertionStatement_tDBSCD_1.setString(4, toScd.Title);
}

                    if(toScd.scd_start == null) {
insertionStatement_tDBSCD_1.setNull(5, java.sql.Types.DATE);
} else {
if(toScd.scd_start != null) {
date_tDBSCD_1 = toScd.scd_start.getTime();
if(date_tDBSCD_1 < year1_tDBSCD_1 || date_tDBSCD_1 >= year10000_tDBSCD_1) {
insertionStatement_tDBSCD_1.setString(5, "0000-00-00 00:00:00");
} else {
insertionStatement_tDBSCD_1.setTimestamp(5, new java.sql.Timestamp(date_tDBSCD_1));
}
} else {
insertionStatement_tDBSCD_1.setNull(5, java.sql.Types.DATE);
}
}

        nb_line_inserted_tDBSCD_1 += insertionStatement_tDBSCD_1.executeUpdate();
    } else {
            if((lookUpValue_tDBSCD_1.DI_WorkflowJobId == null && toScd.DI_WorkflowJobId!= null) || (lookUpValue_tDBSCD_1.DI_WorkflowJobId != null && !lookUpValue_tDBSCD_1.DI_WorkflowJobId.equals(toScd.DI_WorkflowJobId)) || !cu_tDBSCD_1.scdEquals(lookUpValue_tDBSCD_1.DI_CreatedDate,toScd.DI_CreatedDate)) {
                    if(toScd.DI_WorkflowJobId == null) {
updateForType1_tDBSCD_1.setNull(1, java.sql.Types.VARCHAR);
} else {
updateForType1_tDBSCD_1.setString(1, toScd.DI_WorkflowJobId);
}

                    if(toScd.DI_CreatedDate == null) {
updateForType1_tDBSCD_1.setNull(2, java.sql.Types.DATE);
} else {
if(toScd.DI_CreatedDate != null) {
date_tDBSCD_1 = toScd.DI_CreatedDate.getTime();
if(date_tDBSCD_1 < year1_tDBSCD_1 || date_tDBSCD_1 >= year10000_tDBSCD_1) {
updateForType1_tDBSCD_1.setString(2, "0000-00-00 00:00:00");
} else {
updateForType1_tDBSCD_1.setTimestamp(2, new java.sql.Timestamp(date_tDBSCD_1));
}
} else {
updateForType1_tDBSCD_1.setNull(2, java.sql.Types.DATE);
}
}

                    if(toScd.tconst == null) {
updateForType1_tDBSCD_1.setNull(3, java.sql.Types.VARCHAR);
} else {
updateForType1_tDBSCD_1.setString(3, toScd.tconst);
}

                nb_line_update_tDBSCD_1 += updateForType1_tDBSCD_1.executeUpdate();
            }
            if((lookUpValue_tDBSCD_1.Title == null && toScd.Title!= null) || (lookUpValue_tDBSCD_1.Title != null && !lookUpValue_tDBSCD_1.Title.equals(toScd.Title))) {
                    if(toScd.scd_start == null) {
updateForType2_tDBSCD_1.setNull(1, java.sql.Types.DATE);
} else {
if(toScd.scd_start != null) {
date_tDBSCD_1 = toScd.scd_start.getTime();
if(date_tDBSCD_1 < year1_tDBSCD_1 || date_tDBSCD_1 >= year10000_tDBSCD_1) {
updateForType2_tDBSCD_1.setString(1, "0000-00-00 00:00:00");
} else {
updateForType2_tDBSCD_1.setTimestamp(1, new java.sql.Timestamp(date_tDBSCD_1));
}
} else {
updateForType2_tDBSCD_1.setNull(1, java.sql.Types.DATE);
}
}

                    if(toScd.tconst == null) {
updateForType2_tDBSCD_1.setNull(2, java.sql.Types.VARCHAR);
} else {
updateForType2_tDBSCD_1.setString(2, toScd.tconst);
}

                nb_line_update_tDBSCD_1 += updateForType2_tDBSCD_1.executeUpdate();
                            if(toScd.tconst == null) {
insertionStatement_tDBSCD_1.setNull(1, java.sql.Types.VARCHAR);
} else {
insertionStatement_tDBSCD_1.setString(1, toScd.tconst);
}

                            if(toScd.DI_WorkflowJobId == null) {
insertionStatement_tDBSCD_1.setNull(2, java.sql.Types.VARCHAR);
} else {
insertionStatement_tDBSCD_1.setString(2, toScd.DI_WorkflowJobId);
}

                            if(toScd.DI_CreatedDate == null) {
insertionStatement_tDBSCD_1.setNull(3, java.sql.Types.DATE);
} else {
if(toScd.DI_CreatedDate != null) {
date_tDBSCD_1 = toScd.DI_CreatedDate.getTime();
if(date_tDBSCD_1 < year1_tDBSCD_1 || date_tDBSCD_1 >= year10000_tDBSCD_1) {
insertionStatement_tDBSCD_1.setString(3, "0000-00-00 00:00:00");
} else {
insertionStatement_tDBSCD_1.setTimestamp(3, new java.sql.Timestamp(date_tDBSCD_1));
}
} else {
insertionStatement_tDBSCD_1.setNull(3, java.sql.Types.DATE);
}
}

                            if(toScd.Title == null) {
insertionStatement_tDBSCD_1.setNull(4, java.sql.Types.VARCHAR);
} else {
insertionStatement_tDBSCD_1.setString(4, toScd.Title);
}

                            if(toScd.scd_start == null) {
insertionStatement_tDBSCD_1.setNull(5, java.sql.Types.DATE);
} else {
if(toScd.scd_start != null) {
date_tDBSCD_1 = toScd.scd_start.getTime();
if(date_tDBSCD_1 < year1_tDBSCD_1 || date_tDBSCD_1 >= year10000_tDBSCD_1) {
insertionStatement_tDBSCD_1.setString(5, "0000-00-00 00:00:00");
} else {
insertionStatement_tDBSCD_1.setTimestamp(5, new java.sql.Timestamp(date_tDBSCD_1));
}
} else {
insertionStatement_tDBSCD_1.setNull(5, java.sql.Types.DATE);
}
}

                nb_line_inserted_tDBSCD_1 += insertionStatement_tDBSCD_1.executeUpdate();
            }
    }
    
	} catch (java.lang.Exception e) {//catch
globalMap.put("tDBSCD_1_ERROR_MESSAGE",e.getMessage());
  		
                System.err.print(e.getMessage());
	}//end catch
                lookUpValue_tDBSCD_1.DI_WorkflowJobId = toScd.DI_WorkflowJobId;
                lookUpValue_tDBSCD_1.DI_CreatedDate = toScd.DI_CreatedDate;
                lookUpValue_tDBSCD_1.Title = toScd.Title;
        cache_tDBSCD_1.put(lookUpKey_tDBSCD_1, lookUpValue_tDBSCD_1);

 


	tos_count_tDBSCD_1++;

/**
 * [tDBSCD_1 main ] stop
 */
	
	/**
	 * [tDBSCD_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBSCD_1";
	
	
			cLabel="\"dim_title\"";
		

 



/**
 * [tDBSCD_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBSCD_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBSCD_1";
	
	
			cLabel="\"dim_title\"";
		

 



/**
 * [tDBSCD_1 process_data_end ] stop
 */

} // End of branch "toScd"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	

 



/**
 * [tMap_1 process_data_end ] stop
 */



	
	/**
	 * [tUnite_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUnite_1";
	
	

 



/**
 * [tUnite_1 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	
			cLabel="stg_movie_details_v2";
		

 



/**
 * [tDBInput_2 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_2 end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	
			cLabel="stg_movie_details_v2";
		

	}
}finally{
	if (rs_tDBInput_2 != null) {
		rs_tDBInput_2.close();
	}
	if (stmt_tDBInput_2 != null) {
		stmt_tDBInput_2.close();
	}
		if(conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {
			
	    		log.debug("tDBInput_2 - Closing the connection to the database.");
			
			conn_tDBInput_2.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	    		log.debug("tDBInput_2 - Connection to the database closed.");
			
		}
		
}
globalMap.put("tDBInput_2_NB_LINE",nb_line_tDBInput_2);
	    		log.debug("tDBInput_2 - Retrieved records count: "+nb_line_tDBInput_2 + " .");
			

 
                if(log.isDebugEnabled())
            log.debug("tDBInput_2 - "  + ("Done.") );

ok_Hash.put("tDBInput_2", true);
end_Hash.put("tDBInput_2", System.currentTimeMillis());




/**
 * [tDBInput_2 end ] stop
 */
	
	/**
	 * [tUnite_1 end ] start
	 */

	

	
	
	currentComponent="tUnite_1";
	
	

globalMap.put("tUnite_1_NB_LINE", nb_line_tUnite_1);
				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1","row2");
			  	}
			  	
				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"row1",2,0,
				 			"tDBInput_1","stg_movie_details","tMysqlInput","tUnite_1","tUnite_1","tUnite","output")) {
							talendJobLogProcess(globalMap);
						}
					
				 		if(runStat.log(resourceMap,iterateId,"row2",2,0,
				 			"tDBInput_2","stg_movie_details_v2","tMysqlInput","tUnite_1","tUnite_1","tUnite","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 
                if(log.isDebugEnabled())
            log.debug("tUnite_1 - "  + ("Done.") );

ok_Hash.put("tUnite_1", true);
end_Hash.put("tUnite_1", System.currentTimeMillis());




/**
 * [tUnite_1 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	


// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_1 - Written records count in the table 'toScd': " + count_toScd_tMap_1 + ".");





			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row3",2,0,
			 			"tUnite_1","tUnite_1","tUnite","tMap_1","tMap_1","tMap","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + ("Done.") );

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




/**
 * [tMap_1 end ] stop
 */

	
	/**
	 * [tDBSCD_1 end ] start
	 */

	

	
	
	currentComponent="tDBSCD_1";
	
	
			cLabel="\"dim_title\"";
		

    insertionStatement_tDBSCD_1.close();
        updateForType1_tDBSCD_1.close();
        updateForType2_tDBSCD_1.close();
        if(connection_tDBSCD_1 != null && !connection_tDBSCD_1.isClosed()) {
            connection_tDBSCD_1.close();
        }
    globalMap.put("tDBSCD_1_NB_LINE_UPDATED", nb_line_update_tDBSCD_1);
    globalMap.put("tDBSCD_1_NB_LINE_INSERTED", nb_line_inserted_tDBSCD_1);
    globalMap.put("tDBSCD_1_NB_LINE_REJECTED",nb_line_rejected_tDBSCD_1);

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"toScd",2,0,
			 			"tMap_1","tMap_1","tMap","tDBSCD_1","\"dim_title\"","tMysqlSCD","output")) {
						talendJobLogProcess(globalMap);
					}
				
 

ok_Hash.put("tDBSCD_1", true);
end_Hash.put("tDBSCD_1", System.currentTimeMillis());




/**
 * [tDBSCD_1 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="stg_movie_details";
		

 



/**
 * [tDBInput_1 finally ] stop
 */
	
	/**
	 * [tDBInput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	
			cLabel="stg_movie_details_v2";
		

 



/**
 * [tDBInput_2 finally ] stop
 */
	
	/**
	 * [tUnite_1 finally ] start
	 */

	

	
	
	currentComponent="tUnite_1";
	
	

 



/**
 * [tUnite_1 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	

 



/**
 * [tMap_1 finally ] stop
 */

	
	/**
	 * [tDBSCD_1 finally ] start
	 */

	

	
	
	currentComponent="tDBSCD_1";
	
	
			cLabel="\"dim_title\"";
		

 



/**
 * [tDBSCD_1 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}
	


public void tPrejob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tPrejob_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tPrejob_1");
		org.slf4j.MDC.put("_subJobPid", "steL38_" + subJobPidCounter.getAndIncrement());
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tPrejob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tPrejob_1", false);
		start_Hash.put("tPrejob_1", System.currentTimeMillis());
		
	
	currentComponent="tPrejob_1";
	
	
		int tos_count_tPrejob_1 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tPrejob_1", "tPrejob_1", "tPrejob");
				talendJobLogProcess(globalMap);
			}
			

 



/**
 * [tPrejob_1 begin ] stop
 */
	
	/**
	 * [tPrejob_1 main ] start
	 */

	

	
	
	currentComponent="tPrejob_1";
	
	

 


	tos_count_tPrejob_1++;

/**
 * [tPrejob_1 main ] stop
 */
	
	/**
	 * [tPrejob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tPrejob_1";
	
	

 



/**
 * [tPrejob_1 process_data_begin ] stop
 */
	
	/**
	 * [tPrejob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tPrejob_1";
	
	

 



/**
 * [tPrejob_1 process_data_end ] stop
 */
	
	/**
	 * [tPrejob_1 end ] start
	 */

	

	
	
	currentComponent="tPrejob_1";
	
	

 

ok_Hash.put("tPrejob_1", true);
end_Hash.put("tPrejob_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
				}
				tRunJob_1Process(globalMap);



/**
 * [tPrejob_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tPrejob_1 finally ] start
	 */

	

	
	
	currentComponent="tPrejob_1";
	
	

 



/**
 * [tPrejob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tPrejob_1_SUBPROCESS_STATE", 1);
	}
	


public void tRunJob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tRunJob_1");
		org.slf4j.MDC.put("_subJobPid", "OND2hV_" + subJobPidCounter.getAndIncrement());
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tRunJob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_1", false);
		start_Hash.put("tRunJob_1", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_1";
	
	
			cLabel="PreJob";
		
		int tos_count_tRunJob_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tRunJob_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tRunJob_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tRunJob_1 = new StringBuilder();
                    log4jParamters_tRunJob_1.append("Parameters:");
                            log4jParamters_tRunJob_1.append("USE_DYNAMIC_JOB" + " = " + "false");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("PROCESS" + " = " + "pre_job_log");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("USE_INDEPENDENT_PROCESS" + " = " + "false");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("DIE_ON_CHILD_ERROR" + " = " + "true");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("TRANSMIT_WHOLE_CONTEXT" + " = " + "false");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("CONTEXTPARAMS" + " = " + "[{PARAM_NAME_COLUMN="+("job_name")+", PARAM_VALUE_COLUMN="+("context.job_name")+"}, {PARAM_NAME_COLUMN="+("job_status")+", PARAM_VALUE_COLUMN="+("\"Starting\"")+"}]");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("PROPAGATE_CHILD_RESULT" + " = " + "false");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("PRINT_PARAMETER" + " = " + "false");
                        log4jParamters_tRunJob_1.append(" | ");
                            log4jParamters_tRunJob_1.append("USE_DYNAMIC_CONTEXT" + " = " + "false");
                        log4jParamters_tRunJob_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tRunJob_1 - "  + (log4jParamters_tRunJob_1) );
                    } 
                } 
            new BytesLimit65535_tRunJob_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tRunJob_1", "PreJob", "tRunJob");
				talendJobLogProcess(globalMap);
			}
			


 



/**
 * [tRunJob_1 begin ] stop
 */
	
	/**
	 * [tRunJob_1 main ] start
	 */

	

	
	
	currentComponent="tRunJob_1";
	
	
			cLabel="PreJob";
		
	java.util.List<String> paraList_tRunJob_1 = new java.util.ArrayList<String>();
	
	        				paraList_tRunJob_1.add("--father_pid="+pid);
	      			
	        				paraList_tRunJob_1.add("--root_pid="+rootPid);
	      			
	        				paraList_tRunJob_1.add("--father_node=tRunJob_1");
	      			
	        				paraList_tRunJob_1.add("--context=Default");
	      			
			if(!"".equals(log4jLevel)){
				paraList_tRunJob_1.add("--log4jLevel="+log4jLevel);
			}
		
		if(enableLogStash){
			paraList_tRunJob_1.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_1.add("--stat_port=" + portStats);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_1.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_1 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_1 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_1".equals(tRunJobName_tRunJob_1) && childResumePath_tRunJob_1 != null){
		paraList_tRunJob_1.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_1.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_1");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_1 = new java.util.HashMap<String, Object>();

	

	Object obj_tRunJob_1 = null;

	
		obj_tRunJob_1 = context.job_name;
		if(obj_tRunJob_1!=null) {
			if (obj_tRunJob_1.getClass().getName().equals("java.util.Date")) {
				paraList_tRunJob_1.add("--context_param job_name=" + ((java.util.Date) obj_tRunJob_1).getTime());
			} else {
				paraList_tRunJob_1.add("--context_param job_name=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_1));
			}
		} else {
			paraList_tRunJob_1.add("--context_param job_name=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
		}
		
		parentContextMap_tRunJob_1.put("job_name", obj_tRunJob_1);
	
		obj_tRunJob_1 = "Starting";
		if(obj_tRunJob_1!=null) {
			if (obj_tRunJob_1.getClass().getName().equals("java.util.Date")) {
				paraList_tRunJob_1.add("--context_param job_status=" + ((java.util.Date) obj_tRunJob_1).getTime());
			} else {
				paraList_tRunJob_1.add("--context_param job_status=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_1));
			}
		} else {
			paraList_tRunJob_1.add("--context_param job_status=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
		}
		
		parentContextMap_tRunJob_1.put("job_status", obj_tRunJob_1);
	
	
		final_project.pre_job_log_0_1.pre_job_log childJob_tRunJob_1 = new final_project.pre_job_log_0_1.pre_job_log();
	    // pass DataSources
	    java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_1 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
	            .get(KEY_DB_DATASOURCES);
	    if (null != talendDataSources_tRunJob_1) {
	        java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_1 = new java.util.HashMap<String, javax.sql.DataSource>();
	        for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_1 : talendDataSources_tRunJob_1
			        .entrySet()) {
	            dataSources_tRunJob_1.put(talendDataSourceEntry_tRunJob_1.getKey(),
	                    talendDataSourceEntry_tRunJob_1.getValue().getRawDataSource());
	        }
	        childJob_tRunJob_1.setDataSources(dataSources_tRunJob_1);
	    }
		  
			childJob_tRunJob_1.parentContextMap = parentContextMap_tRunJob_1;
		  
		
			log.info("tRunJob_1 - The child job 'final_project.pre_job_log_0_1.pre_job_log' starts on the version '0.1' with the context 'Default'.");
		
		String[][] childReturn_tRunJob_1 = childJob_tRunJob_1.runJob((String[]) paraList_tRunJob_1.toArray(new String[paraList_tRunJob_1.size()]));
		
			log.info("tRunJob_1 - The child job 'final_project.pre_job_log_0_1.pre_job_log' is done.");
		
            if(childJob_tRunJob_1.getErrorCode() == null){
                globalMap.put("tRunJob_1_CHILD_RETURN_CODE", childJob_tRunJob_1.getStatus() != null && ("failure").equals(childJob_tRunJob_1.getStatus()) ? 1 : 0);
            }else{
                globalMap.put("tRunJob_1_CHILD_RETURN_CODE", childJob_tRunJob_1.getErrorCode());
            }
            if (childJob_tRunJob_1.getExceptionStackTrace() != null) {
                globalMap.put("tRunJob_1_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_1.getExceptionStackTrace());
            }
                    errorCode = childJob_tRunJob_1.getErrorCode();
                if (childJob_tRunJob_1.getErrorCode() != null || ("failure").equals(childJob_tRunJob_1.getStatus())) {
                    java.lang.Exception ce_tRunJob_1 = childJob_tRunJob_1.getException();
                    throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_1!=null) ? (ce_tRunJob_1.getClass().getName() + ": " + ce_tRunJob_1.getMessage()) : ""));
                }

 


	tos_count_tRunJob_1++;

/**
 * [tRunJob_1 main ] stop
 */
	
	/**
	 * [tRunJob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_1";
	
	
			cLabel="PreJob";
		

 



/**
 * [tRunJob_1 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_1";
	
	
			cLabel="PreJob";
		

 



/**
 * [tRunJob_1 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_1 end ] start
	 */

	

	
	
	currentComponent="tRunJob_1";
	
	
			cLabel="PreJob";
		

 
                if(log.isDebugEnabled())
            log.debug("tRunJob_1 - "  + ("Done.") );

ok_Hash.put("tRunJob_1", true);
end_Hash.put("tRunJob_1", System.currentTimeMillis());




/**
 * [tRunJob_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_1 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_1";
	
	
			cLabel="PreJob";
		

 



/**
 * [tRunJob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_1_SUBPROCESS_STATE", 1);
	}
	


public void tPostjob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tPostjob_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tPostjob_1");
		org.slf4j.MDC.put("_subJobPid", "Dap7gN_" + subJobPidCounter.getAndIncrement());
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tPostjob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tPostjob_1", false);
		start_Hash.put("tPostjob_1", System.currentTimeMillis());
		
	
	currentComponent="tPostjob_1";
	
	
		int tos_count_tPostjob_1 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tPostjob_1", "tPostjob_1", "tPostjob");
				talendJobLogProcess(globalMap);
			}
			

 



/**
 * [tPostjob_1 begin ] stop
 */
	
	/**
	 * [tPostjob_1 main ] start
	 */

	

	
	
	currentComponent="tPostjob_1";
	
	

 


	tos_count_tPostjob_1++;

/**
 * [tPostjob_1 main ] stop
 */
	
	/**
	 * [tPostjob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tPostjob_1";
	
	

 



/**
 * [tPostjob_1 process_data_begin ] stop
 */
	
	/**
	 * [tPostjob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tPostjob_1";
	
	

 



/**
 * [tPostjob_1 process_data_end ] stop
 */
	
	/**
	 * [tPostjob_1 end ] start
	 */

	

	
	
	currentComponent="tPostjob_1";
	
	

 

ok_Hash.put("tPostjob_1", true);
end_Hash.put("tPostjob_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk2", 0, "ok");
				}
				tRunJob_2Process(globalMap);



/**
 * [tPostjob_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tPostjob_1 finally ] start
	 */

	

	
	
	currentComponent="tPostjob_1";
	
	

 



/**
 * [tPostjob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tPostjob_1_SUBPROCESS_STATE", 1);
	}
	


public void tRunJob_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tRunJob_2");
		org.slf4j.MDC.put("_subJobPid", "SlywrA_" + subJobPidCounter.getAndIncrement());
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tRunJob_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_2", false);
		start_Hash.put("tRunJob_2", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_2";
	
	
			cLabel="PostJob";
		
		int tos_count_tRunJob_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tRunJob_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tRunJob_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tRunJob_2 = new StringBuilder();
                    log4jParamters_tRunJob_2.append("Parameters:");
                            log4jParamters_tRunJob_2.append("USE_DYNAMIC_JOB" + " = " + "false");
                        log4jParamters_tRunJob_2.append(" | ");
                            log4jParamters_tRunJob_2.append("PROCESS" + " = " + "pre_job_log");
                        log4jParamters_tRunJob_2.append(" | ");
                            log4jParamters_tRunJob_2.append("USE_INDEPENDENT_PROCESS" + " = " + "false");
                        log4jParamters_tRunJob_2.append(" | ");
                            log4jParamters_tRunJob_2.append("DIE_ON_CHILD_ERROR" + " = " + "true");
                        log4jParamters_tRunJob_2.append(" | ");
                            log4jParamters_tRunJob_2.append("TRANSMIT_WHOLE_CONTEXT" + " = " + "false");
                        log4jParamters_tRunJob_2.append(" | ");
                            log4jParamters_tRunJob_2.append("CONTEXTPARAMS" + " = " + "[{PARAM_NAME_COLUMN="+("job_name")+", PARAM_VALUE_COLUMN="+("context.job_name")+"}, {PARAM_NAME_COLUMN="+("job_status")+", PARAM_VALUE_COLUMN="+("\"Completed\"")+"}]");
                        log4jParamters_tRunJob_2.append(" | ");
                            log4jParamters_tRunJob_2.append("PROPAGATE_CHILD_RESULT" + " = " + "false");
                        log4jParamters_tRunJob_2.append(" | ");
                            log4jParamters_tRunJob_2.append("PRINT_PARAMETER" + " = " + "false");
                        log4jParamters_tRunJob_2.append(" | ");
                            log4jParamters_tRunJob_2.append("USE_DYNAMIC_CONTEXT" + " = " + "false");
                        log4jParamters_tRunJob_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tRunJob_2 - "  + (log4jParamters_tRunJob_2) );
                    } 
                } 
            new BytesLimit65535_tRunJob_2().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tRunJob_2", "PostJob", "tRunJob");
				talendJobLogProcess(globalMap);
			}
			


 



/**
 * [tRunJob_2 begin ] stop
 */
	
	/**
	 * [tRunJob_2 main ] start
	 */

	

	
	
	currentComponent="tRunJob_2";
	
	
			cLabel="PostJob";
		
	java.util.List<String> paraList_tRunJob_2 = new java.util.ArrayList<String>();
	
	        				paraList_tRunJob_2.add("--father_pid="+pid);
	      			
	        				paraList_tRunJob_2.add("--root_pid="+rootPid);
	      			
	        				paraList_tRunJob_2.add("--father_node=tRunJob_2");
	      			
	        				paraList_tRunJob_2.add("--context=Default");
	      			
			if(!"".equals(log4jLevel)){
				paraList_tRunJob_2.add("--log4jLevel="+log4jLevel);
			}
		
		if(enableLogStash){
			paraList_tRunJob_2.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_2.add("--stat_port=" + portStats);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_2.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_2 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_2 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_2".equals(tRunJobName_tRunJob_2) && childResumePath_tRunJob_2 != null){
		paraList_tRunJob_2.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_2.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_2");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_2 = new java.util.HashMap<String, Object>();

	

	Object obj_tRunJob_2 = null;

	
		obj_tRunJob_2 = context.job_name;
		if(obj_tRunJob_2!=null) {
			if (obj_tRunJob_2.getClass().getName().equals("java.util.Date")) {
				paraList_tRunJob_2.add("--context_param job_name=" + ((java.util.Date) obj_tRunJob_2).getTime());
			} else {
				paraList_tRunJob_2.add("--context_param job_name=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_2));
			}
		} else {
			paraList_tRunJob_2.add("--context_param job_name=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
		}
		
		parentContextMap_tRunJob_2.put("job_name", obj_tRunJob_2);
	
		obj_tRunJob_2 = "Completed";
		if(obj_tRunJob_2!=null) {
			if (obj_tRunJob_2.getClass().getName().equals("java.util.Date")) {
				paraList_tRunJob_2.add("--context_param job_status=" + ((java.util.Date) obj_tRunJob_2).getTime());
			} else {
				paraList_tRunJob_2.add("--context_param job_status=" + RuntimeUtils.tRunJobConvertContext(obj_tRunJob_2));
			}
		} else {
			paraList_tRunJob_2.add("--context_param job_status=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
		}
		
		parentContextMap_tRunJob_2.put("job_status", obj_tRunJob_2);
	
	
		final_project.pre_job_log_0_1.pre_job_log childJob_tRunJob_2 = new final_project.pre_job_log_0_1.pre_job_log();
	    // pass DataSources
	    java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_2 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
	            .get(KEY_DB_DATASOURCES);
	    if (null != talendDataSources_tRunJob_2) {
	        java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_2 = new java.util.HashMap<String, javax.sql.DataSource>();
	        for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_2 : talendDataSources_tRunJob_2
			        .entrySet()) {
	            dataSources_tRunJob_2.put(talendDataSourceEntry_tRunJob_2.getKey(),
	                    talendDataSourceEntry_tRunJob_2.getValue().getRawDataSource());
	        }
	        childJob_tRunJob_2.setDataSources(dataSources_tRunJob_2);
	    }
		  
			childJob_tRunJob_2.parentContextMap = parentContextMap_tRunJob_2;
		  
		
			log.info("tRunJob_2 - The child job 'final_project.pre_job_log_0_1.pre_job_log' starts on the version '0.1' with the context 'Default'.");
		
		String[][] childReturn_tRunJob_2 = childJob_tRunJob_2.runJob((String[]) paraList_tRunJob_2.toArray(new String[paraList_tRunJob_2.size()]));
		
			log.info("tRunJob_2 - The child job 'final_project.pre_job_log_0_1.pre_job_log' is done.");
		
            if(childJob_tRunJob_2.getErrorCode() == null){
                globalMap.put("tRunJob_2_CHILD_RETURN_CODE", childJob_tRunJob_2.getStatus() != null && ("failure").equals(childJob_tRunJob_2.getStatus()) ? 1 : 0);
            }else{
                globalMap.put("tRunJob_2_CHILD_RETURN_CODE", childJob_tRunJob_2.getErrorCode());
            }
            if (childJob_tRunJob_2.getExceptionStackTrace() != null) {
                globalMap.put("tRunJob_2_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_2.getExceptionStackTrace());
            }
                    errorCode = childJob_tRunJob_2.getErrorCode();
                if (childJob_tRunJob_2.getErrorCode() != null || ("failure").equals(childJob_tRunJob_2.getStatus())) {
                    java.lang.Exception ce_tRunJob_2 = childJob_tRunJob_2.getException();
                    throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_2!=null) ? (ce_tRunJob_2.getClass().getName() + ": " + ce_tRunJob_2.getMessage()) : ""));
                }

 


	tos_count_tRunJob_2++;

/**
 * [tRunJob_2 main ] stop
 */
	
	/**
	 * [tRunJob_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_2";
	
	
			cLabel="PostJob";
		

 



/**
 * [tRunJob_2 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_2";
	
	
			cLabel="PostJob";
		

 



/**
 * [tRunJob_2 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_2 end ] start
	 */

	

	
	
	currentComponent="tRunJob_2";
	
	
			cLabel="PostJob";
		

 
                if(log.isDebugEnabled())
            log.debug("tRunJob_2 - "  + ("Done.") );

ok_Hash.put("tRunJob_2", true);
end_Hash.put("tRunJob_2", System.currentTimeMillis());




/**
 * [tRunJob_2 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_2 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_2";
	
	
			cLabel="PostJob";
		

 



/**
 * [tRunJob_2 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_2_SUBPROCESS_STATE", 1);
	}
	


public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "talendJobLog");
		org.slf4j.MDC.put("_subJobPid", "mrIVDg_" + subJobPidCounter.getAndIncrement());
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [talendJobLog begin ] start
	 */

	

	
		
		ok_Hash.put("talendJobLog", false);
		start_Hash.put("talendJobLog", System.currentTimeMillis());
		
	
	currentComponent="talendJobLog";
	
	
		int tos_count_talendJobLog = 0;
		

	for (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : talendJobLog.getMessages()) {
		org.talend.job.audit.JobContextBuilder builder_talendJobLog = org.talend.job.audit.JobContextBuilder.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
			.custom("process_id", jcm.pid).custom("thread_id", jcm.tid).custom("pid", pid).custom("father_pid", fatherPid).custom("root_pid", rootPid);
		org.talend.logging.audit.Context log_context_talendJobLog = null;
		
		
		if(jcm.log_type == JobStructureCatcherUtils.LogType.PERFORMANCE){
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.sourceId(jcm.sourceId).sourceLabel(jcm.sourceLabel).sourceConnectorType(jcm.sourceComponentName)
				.targetId(jcm.targetId).targetLabel(jcm.targetLabel).targetConnectorType(jcm.targetComponentName)
				.connectionName(jcm.current_connector).rows(jcm.row_count).duration(duration).build();
			auditLogger_talendJobLog.flowExecution(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBSTART) {
			log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).build();
			auditLogger_talendJobLog.jobstart(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBEND) {
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
		
			log_context_talendJobLog = builder_talendJobLog
				.timestamp(jcm.moment).duration(duration).status(jcm.status).build();
			auditLogger_talendJobLog.jobstop(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.RUNCOMPONENT) {
			log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment)
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label).build();
			auditLogger_talendJobLog.runcomponent(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWINPUT) {//log current component input line
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label)
				.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
				.rows(jcm.total_row_number).duration(duration).build();
			auditLogger_talendJobLog.flowInput(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWOUTPUT) {//log current component output/reject line
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label)
				.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
				.rows(jcm.total_row_number).duration(duration).build();
			auditLogger_talendJobLog.flowOutput(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBERROR) {
			java.lang.Exception e_talendJobLog = jcm.exception;
			if(e_talendJobLog!=null) {
				try(java.io.StringWriter sw_talendJobLog = new java.io.StringWriter();java.io.PrintWriter pw_talendJobLog = new java.io.PrintWriter(sw_talendJobLog)) {
					e_talendJobLog.printStackTrace(pw_talendJobLog);
					builder_talendJobLog.custom("stacktrace", sw_talendJobLog.getBuffer().substring(0,java.lang.Math.min(sw_talendJobLog.getBuffer().length(), 512)));
				}
			}

			if(jcm.extra_info!=null) {
				builder_talendJobLog.connectorId(jcm.component_id).custom("extra_info", jcm.extra_info);
			}
				
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_id.substring(0, jcm.component_id.lastIndexOf('_')))
				.connectorId(jcm.component_id)
				.connectorLabel(jcm.component_label == null ? jcm.component_id : jcm.component_label).build();

			auditLogger_talendJobLog.exception(log_context_talendJobLog);
		}
		
		
		
	}

 



/**
 * [talendJobLog begin ] stop
 */
	
	/**
	 * [talendJobLog main ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 


	tos_count_talendJobLog++;

/**
 * [talendJobLog main ] stop
 */
	
	/**
	 * [talendJobLog process_data_begin ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 



/**
 * [talendJobLog process_data_begin ] stop
 */
	
	/**
	 * [talendJobLog process_data_end ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 



/**
 * [talendJobLog process_data_end ] stop
 */
	
	/**
	 * [talendJobLog end ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 

ok_Hash.put("talendJobLog", true);
end_Hash.put("talendJobLog", System.currentTimeMillis());




/**
 * [talendJobLog end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [talendJobLog finally ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 



/**
 * [talendJobLog finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("talendJobLog_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Default";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";
    
    private boolean enableLogStash;

    private boolean execStat = true;

    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    
    
    private final static java.util.Properties jobInfo = new java.util.Properties();
    private final static java.util.Map<String,String> mdcInfo = new java.util.HashMap<>();
    private final static java.util.concurrent.atomic.AtomicLong subJobPidCounter = new java.util.concurrent.atomic.AtomicLong();


    public static void main(String[] args){
        final dim_title dim_titleClass = new dim_title();

        int exitCode = dim_titleClass.runJobInTOS(args);
	        if(exitCode==0){
		        log.info("TalendJob: 'dim_title' - Done.");
	        }

        System.exit(exitCode);
    }
	

	
	
	private void getjobInfo() {
		final String TEMPLATE_PATH = "src/main/templates/jobInfo_template.properties";
		final String BUILD_PATH = "../jobInfo.properties";
		final String path = this.getClass().getResource("").getPath();
		if(path.lastIndexOf("target") > 0) {
			final java.io.File templateFile = new java.io.File(
					path.substring(0, path.lastIndexOf("target")).concat(TEMPLATE_PATH));
			if (templateFile.exists()) {
				readJobInfo(templateFile);
				return;
			}
		}
			readJobInfo(new java.io.File(BUILD_PATH));
	}

    private void readJobInfo(java.io.File jobInfoFile){
	
        if(jobInfoFile.exists()) {
            try (java.io.InputStream is = new java.io.FileInputStream(jobInfoFile)) {
            	jobInfo.load(is);
            } catch (IOException e) {
            	 
                log.debug("Read jobInfo.properties file fail: " + e.getMessage());
                
            }
        }
		log.info(String.format("Project name: %s\tJob name: %s\tGIT Commit ID: %s\tTalend Version: %s",
				projectName,jobName,jobInfo.getProperty("gitCommitId"), "8.0.1.20230913_0925-patch"));
		
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";
	   	
        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }
        enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

	        if(!"".equals(log4jLevel)){
	        	
				
				
				if("trace".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.TRACE);
				}else if("debug".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.DEBUG);
				}else if("info".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.INFO);
				}else if("warn".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.WARN);
				}else if("error".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.ERROR);
				}else if("fatal".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.FATAL);
				}else if ("off".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.OFF);
				}
				org.apache.logging.log4j.core.config.Configurator.setLevel(org.apache.logging.log4j.LogManager.getRootLogger().getName(), log.getLevel());
				
			}

	        getjobInfo();
			log.info("TalendJob: 'dim_title' - Start.");
		

                java.util.Set<Object> jobInfoKeys = jobInfo.keySet();
                for(Object jobInfoKey: jobInfoKeys) {
                    org.slf4j.MDC.put("_" + jobInfoKey.toString(), jobInfo.get(jobInfoKey).toString());
                }
                org.slf4j.MDC.put("_pid", pid);
                org.slf4j.MDC.put("_rootPid", rootPid);
                org.slf4j.MDC.put("_fatherPid", fatherPid);
                org.slf4j.MDC.put("_projectName", projectName);
                org.slf4j.MDC.put("_startTimestamp",java.time.ZonedDateTime.now(java.time.ZoneOffset.UTC ).format( java.time.format.DateTimeFormatter.ISO_INSTANT ));
                org.slf4j.MDC.put("_jobRepositoryId","_vosH0JE5Ee6zXrZhesgs5g");
                org.slf4j.MDC.put("_compiledAtTimestamp","2023-12-04T02:08:30.820156700Z");

                java.lang.management.RuntimeMXBean mx = java.lang.management.ManagementFactory.getRuntimeMXBean();
                String[] mxNameTable = mx.getName().split("@"); //$NON-NLS-1$
                if (mxNameTable.length == 2) {
                    org.slf4j.MDC.put("_systemPid", mxNameTable[0]);
                } else {
                    org.slf4j.MDC.put("_systemPid", String.valueOf(java.lang.Thread.currentThread().getId()));
                }

		
		
			if(enableLogStash) {
				java.util.Properties properties_talendJobLog = new java.util.Properties();
				properties_talendJobLog.setProperty("root.logger", "audit");
				properties_talendJobLog.setProperty("encoding", "UTF-8");
				properties_talendJobLog.setProperty("application.name", "Talend Studio");
				properties_talendJobLog.setProperty("service.name", "Talend Studio Job");
				properties_talendJobLog.setProperty("instance.name", "Talend Studio Job Instance");
				properties_talendJobLog.setProperty("propagate.appender.exceptions", "none");
				properties_talendJobLog.setProperty("log.appender", "file");
				properties_talendJobLog.setProperty("appender.file.path", "audit.json");
				properties_talendJobLog.setProperty("appender.file.maxsize", "52428800");
				properties_talendJobLog.setProperty("appender.file.maxbackup", "20");
				properties_talendJobLog.setProperty("host", "false");

				System.getProperties().stringPropertyNames().stream()
					.filter(it -> it.startsWith("audit.logger."))
					.forEach(key -> properties_talendJobLog.setProperty(key.substring("audit.logger.".length()), System.getProperty(key)));

				
				
				
				org.apache.logging.log4j.core.config.Configurator.setLevel(properties_talendJobLog.getProperty("root.logger"), org.apache.logging.log4j.Level.DEBUG);
				
				auditLogger_talendJobLog = org.talend.job.audit.JobEventAuditLoggerFactory.createJobAuditLogger(properties_talendJobLog);
			}
		

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

            org.slf4j.MDC.put("_pid", pid);

        if (rootPid==null) {
            rootPid = pid;
        }

            org.slf4j.MDC.put("_rootPid", rootPid);

        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }
            org.slf4j.MDC.put("_fatherPid", fatherPid);

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }
        boolean inOSGi = routines.system.BundleUtils.inOSGi();

        try {
            java.util.Dictionary<String, Object> jobProperties = null;
            if (inOSGi) {
                jobProperties = routines.system.BundleUtils.getJobProperties(jobName);
    
                if (jobProperties != null && jobProperties.get("context") != null) {
                    contextStr = (String)jobProperties.get("context");
                }
            }
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = dim_title.class.getClassLoader().getResourceAsStream("final_project/dim_title_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = dim_title.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
    	                defaultProps.load(inContext);
    	                if (inOSGi && jobProperties != null) {
                             java.util.Enumeration<String> keys = jobProperties.keys();
                             while (keys.hasMoreElements()) {
                                 String propKey = keys.nextElement();
                                 if (defaultProps.containsKey(propKey)) {
                                     defaultProps.put(propKey, (String) jobProperties.get(propKey));
                                 }
                             }
    	                }
    	                context = new ContextProperties(defaultProps);
                    }
                } finally {
                    inContext.close();
                }
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
            class ContextProcessing {
                private void processContext_0() {
                        context.setContextType("MySqlLocal_Password", "id_Password");
                        if(context.getStringValue("MySqlLocal_Password") == null) {
                            context.MySqlLocal_Password = null;
                        } else {
                            String pwd_MySqlLocal_Password_value = context.getProperty("MySqlLocal_Password");
                            context.MySqlLocal_Password = null;
                            if(pwd_MySqlLocal_Password_value!=null) {
                                if(context_param.containsKey("MySqlLocal_Password")) {//no need to decrypt if it come from program argument or parent job runtime
                                    context.MySqlLocal_Password = pwd_MySqlLocal_Password_value;
                                } else if (!pwd_MySqlLocal_Password_value.isEmpty()) {
                                    try {
                                        context.MySqlLocal_Password = routines.system.PasswordEncryptUtil.decryptPassword(pwd_MySqlLocal_Password_value);
                                        context.put("MySqlLocal_Password",context.MySqlLocal_Password);
                                    } catch (java.lang.RuntimeException e) {
                                        //do nothing
                                    }
                                }
                            }
                        }
                        context.setContextType("MySqlLocal_AdditionalParams", "id_String");
                        if(context.getStringValue("MySqlLocal_AdditionalParams") == null) {
                            context.MySqlLocal_AdditionalParams = null;
                        } else {
                            context.MySqlLocal_AdditionalParams=(String) context.getProperty("MySqlLocal_AdditionalParams");
                        }
                        context.setContextType("MySqlLocal_Login", "id_String");
                        if(context.getStringValue("MySqlLocal_Login") == null) {
                            context.MySqlLocal_Login = null;
                        } else {
                            context.MySqlLocal_Login=(String) context.getProperty("MySqlLocal_Login");
                        }
                        context.setContextType("MySqlLocal_Database", "id_String");
                        if(context.getStringValue("MySqlLocal_Database") == null) {
                            context.MySqlLocal_Database = null;
                        } else {
                            context.MySqlLocal_Database=(String) context.getProperty("MySqlLocal_Database");
                        }
                        context.setContextType("MySqlLocal_Server", "id_String");
                        if(context.getStringValue("MySqlLocal_Server") == null) {
                            context.MySqlLocal_Server = null;
                        } else {
                            context.MySqlLocal_Server=(String) context.getProperty("MySqlLocal_Server");
                        }
                        context.setContextType("MySqlLocal_Port", "id_String");
                        if(context.getStringValue("MySqlLocal_Port") == null) {
                            context.MySqlLocal_Port = null;
                        } else {
                            context.MySqlLocal_Port=(String) context.getProperty("MySqlLocal_Port");
                        }
                        context.setContextType("job_name", "id_String");
                        if(context.getStringValue("job_name") == null) {
                            context.job_name = null;
                        } else {
                            context.job_name=(String) context.getProperty("job_name");
                        }
                } 
                public void processAllContext() {
                        processContext_0();
                }
            }

            new ContextProcessing().processAllContext();
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {if (parentContextMap.containsKey("MySqlLocal_Password")) {
                context.MySqlLocal_Password = (java.lang.String) parentContextMap.get("MySqlLocal_Password");
            }if (parentContextMap.containsKey("MySqlLocal_AdditionalParams")) {
                context.MySqlLocal_AdditionalParams = (String) parentContextMap.get("MySqlLocal_AdditionalParams");
            }if (parentContextMap.containsKey("MySqlLocal_Login")) {
                context.MySqlLocal_Login = (String) parentContextMap.get("MySqlLocal_Login");
            }if (parentContextMap.containsKey("MySqlLocal_Database")) {
                context.MySqlLocal_Database = (String) parentContextMap.get("MySqlLocal_Database");
            }if (parentContextMap.containsKey("MySqlLocal_Server")) {
                context.MySqlLocal_Server = (String) parentContextMap.get("MySqlLocal_Server");
            }if (parentContextMap.containsKey("MySqlLocal_Port")) {
                context.MySqlLocal_Port = (String) parentContextMap.get("MySqlLocal_Port");
            }if (parentContextMap.containsKey("job_name")) {
                context.job_name = (String) parentContextMap.get("job_name");
            }
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
			parametersToEncrypt.add("MySqlLocal_Password");
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,ContextProperties.class,parametersToEncrypt));

            org.slf4j.MDC.put("_context", contextStr);
            log.info("TalendJob: 'dim_title' - Started.");
            java.util.Optional.ofNullable(org.slf4j.MDC.getCopyOfContextMap()).ifPresent(mdcInfo::putAll);

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();


this.globalResumeTicket = true;//to run tPreJob

try {
errorCode = null;tPrejob_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tPrejob_1) {
globalMap.put("tPrejob_1_SUBPROCESS_STATE", -1);

e_tPrejob_1.printStackTrace();

}



		if(enableLogStash) {
	        talendJobLog.addJobStartMessage();
	        try {
	            talendJobLogProcess(globalMap);
	        } catch (java.lang.Exception e) {
	            e.printStackTrace();
	        }
        }

this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tDBInput_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tDBInput_1) {
globalMap.put("tDBInput_1_SUBPROCESS_STATE", -1);

e_tDBInput_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob

try {
errorCode = null;tPostjob_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tPostjob_1) {
globalMap.put("tPostjob_1_SUBPROCESS_STATE", -1);

e_tPostjob_1.printStackTrace();

}



        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : dim_title");
        }
		if(enableLogStash) {
	        talendJobLog.addJobEndMessage(startTime, end, status);
	        try {
	            talendJobLogProcess(globalMap);
	        } catch (java.lang.Exception e) {
	            e.printStackTrace();
	        }
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    int returnCode = 0;


    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");
    resumeUtil.flush();


        org.slf4j.MDC.remove("_subJobName");
        org.slf4j.MDC.remove("_subJobPid");
        org.slf4j.MDC.remove("_systemPid");
        log.info("TalendJob: 'dim_title' - Finished - status: " + status + " returnCode: " + returnCode );

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {


    }














    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();






        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     175300 characters generated by Talend Cloud Data Fabric 
 *     on the December 3, 2023 at 9:08:30 PM EST
 ************************************************************************************************/