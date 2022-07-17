/**
 * Validaçao de formulario
 * @author Nattan Gama
 */
 
 function validar () {
	//alert ('Preencha as informaçoes abaixo')
	let nome = frmContato.nome.value
	let email = frmContato.email.value
	let informacao = frmContato.informacao.value
	if (nome === ""){
		alert ('Preencha o campo Nome')
		frmContato.nome.focus()
		return false	
	}else if (email === "") {
		alert ('Preencha o campo de Email')
		frmContato.email.focus()
		return false
    }else if (informacao === ""){
		alert ('Preencha o campo de Informação')
		frmContato.informacao.focus()
		return false
	}else
	
        document.forms["frmContato"].submit()
 }