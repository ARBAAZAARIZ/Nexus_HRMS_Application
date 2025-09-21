<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login | Society Portal</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <!-- Google Sign-In Script -->
    <script src="https://accounts.google.com/gsi/client" async defer></script>

    <!-- Pastel Styling -->
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #f7f9fc;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }
        h2 {
            color: #4a6fa5;
            margin-bottom: 20px;
        }
        .g_id_signin {
            margin-top: 10px;
        }
    </style>
</head>
<body>

    <h2>Welcome to Portal</h2>
    
    <c:if test="${not empty message}">
    <div class="alert alert-warning">${message}</div>
</c:if>
    
     <h2>Manual login</h2>
    <form action="ManualLogin" method="post" style="margin-top: 20px;">
    <input type="email" name="email" placeholder="Email" required style="padding: 8px; width: 250px;"><br><br>
    <input type="password" name="password" placeholder="Password" required style="padding: 8px; width: 250px;"><br><br>
    <button type="submit" style="padding: 10px 20px; background-color: #4a6fa5; color: white; border: none;">Login</button>
</form>

<h3>Or login with google </h3>

    <!-- Google Sign-In Button -->
    <div id="g_id_onload"
         data-client_id="580884141285-alfgq2rbnk0fq1j6kst6epjt5ij71kfl.apps.googleusercontent.com"
         data-callback="handleCredentialResponse"
         data-auto_prompt="false">
    </div>

    <div class="g_id_signin"
         data-type="standard"
         data-size="large"
         data-theme="outline"
         data-text="sign_in_with"
         data-shape="rectangular"
         data-logo_alignment="left">
    </div>
    
   
    

    <!-- JS to Forward Token to Servlet -->
    <script>
        function handleCredentialResponse(response) {
            const idToken = response.credential;

            const form = document.createElement("form");
            form.method = "POST";
            form.action = "oauth2callback";

            const input = document.createElement("input");
            input.type = "hidden";
            input.name = "idtoken";
            input.value = idToken;

            form.appendChild(input);
            document.body.appendChild(form);
            form.submit();
        }
    </script>

</body>
</html>
