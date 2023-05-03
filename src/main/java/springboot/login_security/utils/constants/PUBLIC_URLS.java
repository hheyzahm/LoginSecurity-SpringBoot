package springboot.login_security.utils.constants;

/**
 * @author Hazeem Hassan
 * @created 03/05/2023 3:58 PM
 */


public class PUBLIC_URLS {
    public static final String API_PATH = "/api/";
    public static final String API_VERSION = API_PATH+ "v1/";   // /api/v1/
    public static final String AUTH_URL = API_VERSION + "auth/"; // /api/v1/auth/
    public static final String AUTH_ALL=AUTH_URL+"**";
    public static final String AUTH_LOGIN=AUTH_URL+"login";
    public static final String AUTH_REGISTER_USER=AUTH_URL+"registerUser";
    public static final String AUTH_REGISTER_ADMIN=AUTH_URL+"registerAdmin";
    public static final String AUTH_CURRENT_USER=AUTH_URL+"current-user/";
    public static final String GRAPHQL = API_VERSION + "graphql"; // /api/v1/graphql/
    public static final String GRAPHIQL = API_VERSION + "graphiql"; // /api/v1/graphiql
    public static final String API_DOCS = API_VERSION + "api-docs";// /api/v1/api-docs
    public static final String SWAGGER_RESOURCES = API_VERSION + "swagger-resources/**"; // /api/v1/swagger-resources/
    public static final String SWAGGER_UI = API_VERSION + "swagger-ui/**"; // /api/v1/swagger-ui/
    public static final String REST_CONTROLLER = API_VERSION + "RC/"; // /api/v1/RC/
    public static final String REST_CONTROLLER_USER = REST_CONTROLLER + "users"; // /api/v1/RC/users

    public static final String REST_CONTROLLER_GET_ALL_USER = REST_CONTROLLER_USER + "/getAllUsers"; // /api/v1/RC/users/getAllUsers
    public static final String REST_CONTROLLER_FETCH_SINGLE_USER=REST_CONTROLLER_USER+"/fetchUserById/";
    public static final String REST_CONTROLLER_UPDATE_USER=REST_CONTROLLER_USER+"/updateUserById/";
    public static final String REST_CONTROLLER_DELETE_USER=REST_CONTROLLER_USER+"/deleteUserById/";
    public static final String REST_CONTROLLER_CREATE_USER=REST_CONTROLLER_USER+"/createNewUser/";

    //  public static final String ="";
}
