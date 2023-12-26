

myForm.onsubmit = function() {
    console.log(myForm.name.value);
    console.log(myForm.password.value);



    //检验检验用户名只能是字母和数字，必须以字母开头，长度为6到12位
    var reg = /^[a-zA-Z][a-zA-Z0-9]{5,11}&/;
    if(!reg.test(myForm.name.value)) {
        //取name 元素的下一个兄弟元素
        myForm.name.nextElementSibling.innerHTML = '用户名不合法';
        myForm.name.style.outlineColor = 'red';
    } else {
        myForm.name.nextElementSibling.innerHTML = '';
        myForm.name.style.outlineColor = '';
    }
    return false;
}