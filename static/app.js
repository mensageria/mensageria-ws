var stompClient = null;

function setConnected(connected) {
	$("#connect").prop("disabled", connected);
	$("#disconnect").prop("disabled", !connected);
	if (connected) {
		$("#conversation").show();
	} else {
		$("#conversation").hide();
	}
	$("#greetings").html("");
}

function connect() {
	var socket = new SockJS('/mensageria');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		setConnected(true);
		console.log('Connected: ' + frame);
		getPreviousMessages();
		stompClient.subscribe('/topic/mensagens/conversa/'+ $("#conversaId").val(), function(res) {
			let mensagens = JSON.parse(res.body)
			console.log('mensagem:',mensagens)
			if(mensagens.length){
				mensagens.forEach(mensagem => {
					showGreeting(mensagem);
				})
			}else{
				showGreeting(mensagens);
			}
		});
		stompClient.subscribe('/topic/mensagens/conversa/'+ 6, function(res) {
			let mensagens = JSON.parse(res.body)
			console.log('mensagem:',mensagens)
			if(mensagens.length){
				mensagens.forEach(mensagem => {
					showGreeting(mensagem);
				})
			}else{
				showGreeting(mensagens);
			}
		});
	});
}

function disconnect() {
	if (stompClient !== null) {
		stompClient.disconnect();
	}
	setConnected(false);
	console.log("Disconnected");
}

function getPreviousMessages() {
    $.get('/api/mensagens/conversa?chatId=' + $("#conversaId").val()).done(messages => messages.forEach(showGreeting));
}

function sendName() {
	let chat = {
		id: null,
		interativa : null,
		nome : null,
		dataCriacao : null,
		ultimaMensagem: null
	}
	chat.id = $("#conversaId").val()
	
	let autor = {
		id: null,
		email : null,
		emailConfirmado : null,
		nome : 'Allison',
		ultimoAcesso : null
	}
	
	autor.id = 1
	autor.nome = 'joao'
	
	let mensagem = {
		conteudo : null,
		autor : autor,
		dataEnvio : null,
		chat : chat
	}
	
	mensagem.dataEnvio = new Date()
	mensagem.conteudo = $("#conteudo").val()
	stompClient.send('/app/enviar/mensagens/conversa/' + $("#conversaId").val(), {}, JSON.stringify(mensagem));
}

function sendReceive(mensagem){
	
	let recebe = {
		id:{
			mensagem:mensagem.id,
			usuario:1
		}
	}
	console.log("recebe",recebe)
	stompClient.send('/app/receber/mensagens/conversa/' + $("#conversaId").val(), {}, JSON.stringify(recebe));
}

function showGreeting(message) {
	let autor = message.autor
	$("#greetings").append("<tr><td>" + autor.nome + ": " + message.conteudo + "</td></tr>");
	sendReceive(message);
}

$(function() {
	$("form").on('submit', function(e) {
		e.preventDefault();
	});
	$("#connect").click(function() {
		connect();
	});
	$("#disconnect").click(function() {
		disconnect();
	});
	$("#send").click(function() {
		sendName();
	});
});