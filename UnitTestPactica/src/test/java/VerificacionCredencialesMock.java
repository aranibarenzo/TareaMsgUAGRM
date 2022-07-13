import authentication.Authentication;
import authentication.CredentialsService;
import authentication.PermissionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.naming.AuthenticationException;

public class VerificacionCredencialesMock {
    //private Object Mockito;

    CredentialsService credentialsServiceMock= Mockito.mock(CredentialsService.class);
    PermissionService permissionServiceMock=Mockito.mock(PermissionService.class);
    //Authentication authentication;
    public  VerificacionCredencialesMock(){
       // authentication=new Authentication();
    };

    //Verificaion de Pruebas unitarias con Usuario Correcto CRUD
    @Test
    public void verificarLoginMock(){
        String permission="CRUD";
        //ear@hmail.com enzoaranibar@gmail.com
        Mockito.when(credentialsServiceMock.isValidCredential("ear@hmail.com","123456")).thenReturn(true);
        Mockito.when(permissionServiceMock.getPermission("ear@hmail.com")).thenReturn("CRUD");

        Authentication authentication=new Authentication();
        authentication.setCredentialsService(credentialsServiceMock);
        authentication.setPermissionService(permissionServiceMock);

        String expectedResult="user authenticated successfully with permission: ["+permission+"]";//"user or password incorrect";//
        String actualResult=authentication.login("ear@hmail.com","123456");
        Assertions.assertEquals(expectedResult,actualResult,"Error Autentifica");


        Mockito.verify(credentialsServiceMock).isValidCredential("ear@hmail.com","123456");
        Mockito.verify(permissionServiceMock).getPermission("ear@hmail.com");

    }
    //Usando los datos para Usuario con privilegios de Lectura=R
    @Test
    public void verificarLoginMock_R(){
        String permission="R";
        //ear@hmail.com enzoaranibar@gmail.com
        Mockito.when(credentialsServiceMock.isValidCredential("enzo@gmail.com","1234567")).thenReturn(true);
        Mockito.when(permissionServiceMock.getPermission("enzo@gmail.com")).thenReturn("R");

        Authentication authentication=new Authentication();
        authentication.setCredentialsService(credentialsServiceMock);
        authentication.setPermissionService(permissionServiceMock);

        String expectedResult="user authenticated successfully with permission: ["+permission+"]";//"user or password incorrect";//
        String actualResult=authentication.login("enzo@gmail.com","1234567");
        Assertions.assertEquals(expectedResult,actualResult,"Error Autentificacion");


        Mockito.verify(credentialsServiceMock).isValidCredential("enzo@gmail.com","1234567");
        Mockito.verify(permissionServiceMock).getPermission("enzo@gmail.com");

    }
    //verificar Login para un usuario con Privilegios de Creacion=C, Eliminacion=D
    @Test
    public void verificarLoginMock_CD(){
        String permission="CD";

        Mockito.when(credentialsServiceMock.isValidCredential("enzo@hotmail.com","Ar@nib@r")).thenReturn(true);
        Mockito.when(permissionServiceMock.getPermission("enzo@hotmail.com")).thenReturn("CD");

        Authentication authentication=new Authentication();
        authentication.setCredentialsService(credentialsServiceMock);
        authentication.setPermissionService(permissionServiceMock);

        String expectedResult="user authenticated successfully with permission: ["+permission+"]";
        String actualResult=authentication.login("enzo@hotmail.com","Ar@nib@r");
        Assertions.assertEquals(expectedResult,actualResult,"Error Autentificacion");


        Mockito.verify(credentialsServiceMock).isValidCredential("enzo@hotmail.com","Ar@nib@r");
        Mockito.verify(permissionServiceMock).getPermission("enzo@hotmail.com");

    }

    //verificar Login para un usuario con Privilegios de Actualizacion=U
    @Test
    public void verificarLoginMock_U(){
        String permission="U";

        Mockito.when(credentialsServiceMock.isValidCredential("nixon@microsoft.com","2020*/.")).thenReturn(true);
        Mockito.when(permissionServiceMock.getPermission("nixon@microsoft.com")).thenReturn("U");

        Authentication authentication=new Authentication();
        authentication.setCredentialsService(credentialsServiceMock);
        authentication.setPermissionService(permissionServiceMock);

        String expectedResult="user authenticated successfully with permission: ["+permission+"]";
        String actualResult=authentication.login("nixon@microsoft.com","2020*/.");
        Assertions.assertEquals(expectedResult,actualResult,"Error Autentificacion");


        Mockito.verify(credentialsServiceMock).isValidCredential("nixon@microsoft.com","2020*/.");
        Mockito.verify(permissionServiceMock).getPermission("nixon@microsoft.com");

    }
}
