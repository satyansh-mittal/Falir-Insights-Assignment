const form = document.getElementById('personalForm');
const outputDiv = document.getElementById('output');

form.addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent form submission

    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const age = document.getElementById('age').value;

    // Create a visually appealing output
    const output = `
        <h2>Submitted Information</h2>
        <p><strong>Name:</strong> ${name}</p>
        <p><strong>Email:</strong> ${email}</p>
        <p><strong>Age:</strong> ${age}</p>
    `;

    outputDiv.innerHTML = output;
    form.reset(); // Reset form fields
});