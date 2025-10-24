document.getElementById("regForm").addEventListener("submit", function (event) {
  event.preventDefault(); // Prevent form submission

  // Clear previous messages
  document.querySelectorAll(".error").forEach(e => e.textContent = "");
  document.getElementById("successMessage").textContent = "";

  // Get input values
  let fname = document.getElementById("fname").value.trim();
  let lname = document.getElementById("lname").value.trim();
  let email = document.getElementById("email").value.trim();
  let userid = document.getElementById("userid").value.trim();
  let password = document.getElementById("password").value.trim();
  let confPassword = document.getElementById("confPassword").value.trim();

  let isValid = true;

  // First name
  if (fname === "") {
    document.getElementById("fnameError").textContent = "First name is required.";
    isValid = false;
  }

  // Last name
  if (lname === "") {
    document.getElementById("lnameError").textContent = "Last name is required.";
    isValid = false;
  }

  // Email validation
  const emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
  if (email === "") {
    document.getElementById("emailError").textContent = "Email is required.";
    isValid = false;
  } else if (!email.match(emailPattern)) {
    document.getElementById("emailError").textContent = "Invalid email format.";
    isValid = false;
  }

  // User ID
  if (userid === "") {
    document.getElementById("useridError").textContent = "User ID is required.";
    isValid = false;
  }

  // Password
  if (password === "") {
    document.getElementById("passwordError").textContent = "Password is required.";
    isValid = false;
  }

  // Confirm Password
  if (confPassword === "") {
    document.getElementById("confPasswordError").textContent = "Confirm password is required.";
    isValid = false;
  } else if (password !== confPassword) {
    document.getElementById("confPasswordError").textContent = "Passwords do not match.";
    isValid = false;
  }

  // If all fields valid
  if (isValid) {
    document.getElementById("successMessage").textContent = "Registration successful!";
  }
});
