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
		stompClient.send('/app/mensagens/conversa/' + $("#conversaId").val(), {});
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
	});
}

function disconnect() {
	if (stompClient !== null) {
		stompClient.disconnect();
	}
	setConnected(false);
	console.log("Disconnected");
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

function showGreeting(message) {
	let autor = message.autor
	$("#greetings").append("<tr><td>" + autor.nome + ": " + message.conteudo + "</td></tr>");
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