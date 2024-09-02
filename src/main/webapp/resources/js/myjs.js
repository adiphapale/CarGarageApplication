/**
 * 
 */

document
	.getElementById('inputContact4')
	.addEventListener(
		'input',
		function() {
			const contact = this.value;
			const validationMessage = document
				.getElementById('validationMessage');

			if (contact.length > 10) {
				validationMessage.textContent = "Invalid Contact Number";
			} else if (!/^[6-9]\d{0,9}$/.test(contact)) {
				validationMessage.textContent = "Invalid Contact Number";
			} else {
				validationMessage.textContent = "";
			}
		});
		

document.getElementById('inputEmail4').addEventListener('input', function () {
    const email = this.value;
    const validationMessage = document.getElementById('emailValidationMessage');
    
    // Basic email pattern to check the format
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    
    if (!emailPattern.test(email)) {
        validationMessage.textContent = "Invalid email address.";
    } else {
        validationMessage.textContent = "";
    }
});
