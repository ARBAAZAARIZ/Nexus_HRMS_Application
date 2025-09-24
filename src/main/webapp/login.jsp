<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login | NEsus HRMS Portal</title>
    
    <!-- Google Sign-In Script -->
    <script src="https://accounts.google.com/gsi/client" async defer></script>
    
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    
    
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }
        
        body {
            background: linear-gradient(120deg, #a1c4fd 0%, #c2e9fb 100%);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
        }
        
        .login-container {
            background: rgba(255, 255, 255, 0.95);
            border-radius: 16px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.15);
            width: 100%;
            max-width: 430px;
            padding: 35px 30px;
            text-align: center;
            backdrop-filter: blur(10px);
            border: 1px solid rgba(255, 255, 255, 0.3);
            max-height: 90vh; /* Limit container height */
            overflow: hidden; /* Prevent scrolling */
        }
        
        .logo {
            margin-bottom: 5px;
            
        }
        
        .logo i {
            font-size: 42px;
            color: #4a6fa5;
            background: linear-gradient(135deg, #4a6fa5, #6c63ff);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            background-clip: text;
        }
        
        h2 {
            color: #2d3748;
            margin-bottom: 8px;
            font-weight: 600;
            font-size: 24px;
        }
        
        .subtitle {
            color: #718096;
            margin-bottom: 25px;
            font-size: 15px;
        }
        
        .alert {
            background: #fff3cd;
            color: #856404;
            padding: 10px;
            border-radius: 8px;
            margin-bottom: 18px;
            font-size: 13px;
            border-left: 4px solid #ffc107;
        }
        
        .form-group {
            margin-bottom: 18px;
            text-align: left;
        }
        
        .form-group label {
            display: block;
            margin-bottom: 6px;
            color: #2d3748;
            font-weight: 500;
            font-size: 14px;
        }
        
        .input-with-icon {
            position: relative;
        }
        
        .input-with-icon i {
            position: absolute;
            left: 14px;
            top: 50%;
            transform: translateY(-50%);
            color: #a0aec0;
            font-size: 16px;
        }
        
        .input-with-icon input {
            width: 100%;
            padding: 12px 12px 12px 42px;
            border: 1px solid #e2e8f0;
            border-radius: 10px;
            font-size: 15px;
            transition: all 0.3s ease;
        }
        
        .input-with-icon input:focus {
            outline: none;
            border-color: #4a6fa5;
            box-shadow: 0 0 0 3px rgba(74, 111, 165, 0.2);
        }
        
        .login-btn {
            width: 100%;
            padding: 13px;
            background: linear-gradient(135deg, #4a6fa5 0%, #6c63ff 100%);
            color: white;
            border: none;
            border-radius: 10px;
            font-size: 15px;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
            box-shadow: 0 4px 10px rgba(106, 99, 255, 0.3);
            margin-top: 5px;
        }
        
        .login-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 6px 15px rgba(106, 99, 255, 0.4);
        }
        
        .divider {
            display: flex;
            align-items: center;
            margin: 25px 0;
            color: #a0aec0;
        }
        
        .divider::before,
        .divider::after {
            content: "";
            flex: 1;
            height: 1px;
            background: #e2e8f0;
        }
        
        .divider span {
            padding: 0 12px;
            font-size: 13px;
        }
        
        .google-btn-container {
            margin-bottom: 20px;
        }
        
        .forgot-password {
            display: block;
            margin-top: 18px;
            color: #4a6fa5;
            text-decoration: none;
            font-size: 14px;
            transition: all 0.3s ease;
        }
        
        .forgot-password:hover {
            color: #6c63ff;
            text-decoration: underline;
        }
        
        .footer {
            margin-top: 25px;
            color: #718096;
            font-size: 13px;
        }
        
        .footer a {
            color: #4a6fa5;
            text-decoration: none;
        }
        
        .footer a:hover {
            text-decoration: underline;
        }
        
        /* Responsive adjustments */
        @media (max-width: 480px) {
            .login-container {
                padding: 25px 20px;
                max-width: 90%;
            }
            
            h2 {
                font-size: 22px;
            }
            
            .subtitle {
                font-size: 14px;
                margin-bottom: 20px;
            }
            
            .input-with-icon input {
                padding: 11px 11px 11px 40px;
            }
            
            .divider {
                margin: 20px 0;
            }
        }
        
        @media (max-height: 700px) {
            .login-container {
                padding: 25px 25px;
                max-height: 95vh;
            }
            
            .logo {
                margin-bottom: 3px;
            }
            
            .logo i {
                font-size: 36px;
            }
            
            h2 {
                font-size: 22px;
                margin-bottom: 5px;
            }
            
            .subtitle {
                margin-bottom: 20px;
                font-size: 14px;
            }
            
            .form-group {
                margin-bottom: 15px;
            }
            
            .divider {
                margin: 20px 0;
            }
            
            .footer {
                margin-top: 20px;
            }
        }
    </style>
</head>
<body>
    <div class="login-container">
        <div class="logo">
            <i class="fa-brands fa-old-republic"></i>
        </div>
        
        <h2>Welcome to Nexus HRMS Portal</h2>
        <p class="subtitle">Sign in to access your account</p>
        
        
        <c:if test="${not empty message}">
			  <div class="alert alert-danger" role="alert">
			    ${message}
 			  </div>
		</c:if>
        <!-- Manual Login Form -->
        <form action="ManualLogin" method="post">
            <div class="form-group">
                <label for="email">Email Address</label>
                <div class="input-with-icon">
                    <i class="fas fa-envelope"></i>
                    <input type="email" id="email" name="email" placeholder="Enter your email" required>
                </div>
            </div>
            
            <div class="form-group">
                <label for="password">Password</label>
                <div class="input-with-icon">
                    <i class="fas fa-lock"></i>
                    <input type="password" id="password" name="password" placeholder="Enter your password" required>
                </div>
            </div>
            
            <button type="submit" class="login-btn">Sign In</button>
            
            <a href="#" class="forgot-password">Forgot Password?</a>
        </form>
        
        <div class="divider">
            <span>Or continue with</span>
        </div>
        
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
        
        <div class="footer">
            <p>Don't have an account? <a href="#">Contact Administrator</a></p>
        </div>
    </div>
    
    
    
    <!-- Email Modal -->
<div class="modal fade" tabindex="-1" id="emailModal" aria-hidden="true">
  <div class="modal-dialog">
    <form id="emailForm" method="post" action="ForgotPasswordEmail">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">Forgot Password - Enter Email</h5>
          <button type="button" class="btn-close" onclick="closeModal('emailModal')"></button>
        </div>
        <div class="modal-body">
          <div id="emailError" class="alert alert-danger d-none"></div>
          <input type="email" name="email" class="form-control" placeholder="Enter your registered email" required />
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-primary">Send OTP</button>
        </div>
      </div>
    </form>
  </div>
</div>

<!-- OTP Modal -->
<div class="modal fade"  tabindex="-1" id="otpModal" aria-hidden="true">
  <div class="modal-dialog">
    <form id="otpForm" method="post" action="ForgotPasswordOtp">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">Enter OTP</h5>
          <button type="button" class="btn-close" onclick="closeModal('otpModal')"></button>
        </div>
        <div class="modal-body">
          <div id="otpError" class="alert alert-danger d-none"></div>
          <input type="text" name="otp" class="form-control" placeholder="Enter 6-digit OTP" pattern="[0-9]{6}" required />
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-primary">Verify OTP</button>
        </div>
      </div>
    </form>
  </div>
</div>

<!-- Change Password Modal -->
<div class="modal fade"  tabindex="-1" id="changePasswordModal" aria-hidden="true">
  <div class="modal-dialog">
    <form id="changePassForm" method="post" action="ForgotPasswordChange">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">Change Password</h5>
          <button type="button" class="btn-close" onclick="closeModal('changePasswordModal')"></button>
        </div>
        <div class="modal-body">
          <input type="password" name="newPassword" class="form-control" placeholder="Enter new password" required minlength="6" />
          <input type="password" name="confirmPassword" class="form-control mt-2" placeholder="Confirm new password" required minlength="6" />
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-primary">Update Password</button>
        </div>
      </div>
    </form>
  </div>
</div>

<script>
window.onload = function() {
    <% if(request.getAttribute("emailError") != null) { %>
        openModal('emailModal');
        document.getElementById('emailError').textContent = '<%= request.getAttribute("emailError") %>';
        document.getElementById('emailError').classList.remove('d-none');
    <% } else if (request.getAttribute("openOtpModal") != null) { %>
        openModal('otpModal');
    <% } else if (request.getAttribute("otpError") != null) { %>
        openModal('otpModal');
        document.getElementById('otpError').textContent = '<%= request.getAttribute("otpError") %>';
        document.getElementById('otpError').classList.remove('d-none');
    <% } else if (request.getAttribute("openChangePassModal") != null) { %>
        openModal('changePasswordModal');
    <% } else if (request.getParameter("msg") != null) { %>
        alert('<%= request.getParameter("msg") %>');
    <% } %>
}
</script>

    

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
        
        // Simple animation for input focus
        document.querySelectorAll('.input-with-icon input').forEach(input => {
            input.addEventListener('focus', function() {
                this.parentElement.querySelector('i').style.color = '#4a6fa5';
            });
            
            input.addEventListener('blur', function() {
                this.parentElement.querySelector('i').style.color = '#a0aec0';
            });
        });
    </script>
    
    
    <script>
  function openModal(modalId) {
    new bootstrap.Modal(document.getElementById(modalId)).show();
  }
  function closeModal(modalId) {
    const modal = bootstrap.Modal.getInstance(document.getElementById(modalId));
    modal && modal.hide();
  }
  
  // Initially open email modal on 'forgot password' click:
  document.querySelector('.forgot-password').addEventListener('click', function(e) {
    e.preventDefault();
    openModal('emailModal');
  });

  // Helpers to display server errors; server can forward error messages as request attributes and based on them open specific modals with error populated (implemented in servlet responses)
  function showModalError(modalId, errorId, message) {
    const errorDiv = document.getElementById(errorId);
    errorDiv.textContent = message;
    errorDiv.classList.remove('d-none');
    openModal(modalId);
  }
</script>
    
    
    
</body>
</html>