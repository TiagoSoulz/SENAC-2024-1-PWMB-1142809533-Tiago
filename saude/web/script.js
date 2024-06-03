// Função para mostrar o formulário de busca
function showSearchForm() {
    document.getElementById('search-form').style.display = 'block';
}

// Função para lidar com a submissão do formulário de busca
document.getElementById('search-form').addEventListener('submit', function(event) {
    event.preventDefault();
    const searchTerm = document.getElementById('search-input').value.trim();
    console.log('Buscando paciente com termo:', searchTerm);
});

function searchPatient() {
    var name = document.getElementById("search-input").value;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            // Manipule a resposta aqui, por exemplo, atualizando a interface do usuário com os resultados
            console.log(xhr.responseText);
        }
    };
    xhr.open("GET", "tt.php?name=" + name, true);
    xhr.send();
}

function insertPatient() {
    var name = document.getElementById("insert-name").value;
    var age = document.getElementById("insert-age").value;
    var address = document.getElementById("insert-address").value;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            // Manipule a resposta aqui, por exemplo, exibindo uma mensagem de sucesso
            console.log(xhr.responseText);
        }
    };
    xhr.open("POST", "tt.php", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send("name=" + name + "&age=" + age + "&address=" + address);
}

function updatePatient() {
    var id = document.getElementById("update-id").value;
    var name = document.getElementById("update-name").value;
    var age = document.getElementById("update-age").value;
    var address = document.getElementById("update-address").value;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            // Manipule a resposta aqui, por exemplo, exibindo uma mensagem de sucesso
            console.log(xhr.responseText);
        }
    };
    xhr.open("POST", "tt.php", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send("id=" + id + "&name=" + name + "&age=" + age + "&address=" + address);
}

function deletePatient() {
    var id = document.getElementById("delete-id").value;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            // Manipule a resposta aqui, por exemplo, exibindo uma mensagem de sucesso
            console.log(xhr.responseText);
        }
    };
    xhr.open("POST", "tt.php", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send("id=" + id);
}




function showForm(formId) {
    // Oculta todos os formulários
    var forms = document.querySelectorAll('.crud-form');
    forms.forEach(function(form) {
        form.style.display = 'none';
    });

    // Exibe o formulário selecionado
    var selectedForm = document.getElementById(formId);
    selectedForm.style.display = 'block';
}

document.getElementById('patient-form').addEventListener('submit', function(event) {
    // Impede o envio do formulário
    event.preventDefault();
    alert('Paciente inserido com sucesso!');
});

    // Função para permitir apenas números em campos numéricos
    function allowOnlyNumbers(input) {
        input.value = input.value.replace(/\D/g, '');
    }

// Função para verificar se as senhas correspondem e mostrar mensagem de sucesso
function registrar() {
    var senha = document.getElementById("senha").value;
    var confirmarSenha = document.getElementById("confirmar-senha").value;

    if (senha !== confirmarSenha) {
        alert("As senhas não coincidem.");
        return false;
    }
    
    // Simula o registro bem-sucedido
    alert("Cadastro realizado com sucesso!");
    // Redireciona para a página de login após 1 segundo
    setTimeout(function() {
        window.location.href = "login.html";
    }, 1000);

    return true;
}
