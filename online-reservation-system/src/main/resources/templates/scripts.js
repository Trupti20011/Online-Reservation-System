document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    fetch('/users/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, password }),
    })
    .then(response => response.json())
    .then(data => {
        console.log('Login Success:', data);
        alert('Login Successful');
    })
    .catch((error) => {
        console.error('Login Error:', error);
        alert('Login Failed');
    });
});

document.getElementById('reservationForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const reservationData = {
        userId: document.getElementById('userId').value,
        trainId: document.getElementById('trainId').value,
        classType: document.getElementById('classType').value,
        dateOfJourney: document.getElementById('dateOfJourney').value,
        fromPlace: document.getElementById('fromPlace').value,
        toPlace: document.getElementById('toPlace').value,
    };

    fetch('/reservations/book', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(reservationData),
    })
    .then(response => response.json())
    .then(data => {
        console.log('Reservation Success:', data);
        alert('Reservation Successful');
    })
    .catch((error) => {
        console.error('Reservation Error:', error);
        alert('Reservation Failed');
    });
});

document.getElementById('cancellationForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const pnrNumber = document.getElementById('pnrNumber').value;

    fetch(`/cancellations/cancel?pnrNumber=${pnrNumber}`, {
        method: 'POST',
    })
    .then(response => response.json())
    .then(data => {
        console.log('Cancellation Success:', data);
        alert('Cancellation Successful');
    })
    .catch((error) => {
        console.error('Cancellation Error:', error);
        alert('Cancellation Failed');
    });
});
