<template>
  <div class="container">

    <div class="form">
      <div class="forms">
        <div class="title">Login</div>

        <div class="input-field">
          <input type="text" placeholder="Enter your username" v-model="username" required>
          <i class="uil uil-envelope icon"></i>
        </div>
        <div class="input-field">
          <input type="password" class="password" placeholder="Enter your password" v-model="pw" required>
          <i class="uil uil-lock icon"></i>
          <i class="uil uil-eye-slash showHidePw"></i>
        </div>

        <div class="checkbox-text">
          <div class="checkbox-content">
            <input type="checkbox" id="logCheck">
            <label for="logCheck" class="text">Remember me</label>
          </div>

          <button class="text">Forgot password?</button>
        </div>

        <div class="input-field button">
          <input type="button" value="Login Now" v-on:click="login">
        </div>

        <div class="login-signup">
          <span class="text">Not a member?
            <!--<a href="#" class="text signup-link">Signup now</a>-->
              <button class="text signup-link" v-on:click="gotoRegister">Sign up now</button>
          </span>
        </div>
      </div>

    </div>
  </div>

</template>

<script>
import axios from "axios";

export default {
  name: "Login",
  components: {
  },
  data(){
    return({
      username: '',
      pw: '',
      errorMsg:'',
      res:''
    })
  },
  methods:{
    async login(){
      this.errorMsg = ''
      const userJson = {
        "username": this.username,
        "password": this.pw
      };

      await axios.post("https://medicaldevicesrental.herokuapp.com/api/loginPage/login", userJson,{
        headers: {
          "Access-Control-Allow-Origin": "*",
          "content-Type": "application/json",
        }
      }).then(response => {
        console.log(response.data)
        this.res = response.data

      });

      console.log('outside...............')
      console.log(this.res)

      await this.$router.push({name:'SearchPage', params: {name:this.res.name}})

    },
    gotoRegister(){
      console.log('go to register')
      this.$router.push({name:'Register'})
    }
  }
}
</script>

<style scoped>
@import url('https://f...content-available-to-author-only...s.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap');

*{
  margin: 0;
  padding: 0;
  /*box-sizing: border-box;*/
  font-family: 'Poppins', sans-serif;
}

.container{
  height: 720px;
  position: relative;
  display: grid;
  grid-template-rows: auto auto auto ;
  grid-template-columns: auto auto auto auto auto;
}

.form{
  /*height: 100vh;*/
  /*display: flex;*/
  /*align-items: center;*/
  /*justify-content: center;*/
  background-color: rgba(64, 112, 244, 0.6);
  border-radius: 10px;
  grid-column-start: 3;
  grid-column-end: 4;
  grid-row-start: 2;
  grid-row-end: 3;

  display: grid;
  grid-template-rows: 25% 10% 10% 10% 10% 10% 10%;
  grid-template-columns: auto;

}

.title{
  height: 100%;
  grid-column-start: 1;
  grid-column-end: 2;
  grid-row-start: 1;
  grid-row-end: 2;
  font-size: 27px;
  font-weight: 600;
  padding-top: 20px;
}

/*.form{*/
/*  !*position: relative;*!*/
/*  !*max-width: 430px;*!*/
/*  !*width: 200%;*!*/
/*  height: 50%;*/
/*  width: 50%;*/
/*  background: #fff;*/
/*  border-radius: 10px;*/
/*  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);*/
/*  !*overflow: hidden;*!*/
/*  !*margin: 0 0px;*!*/
/*  margin: 0 auto;*/
/*  position: absolute;*/
/*  top: 50%;*/
/*}*/

/*.container .forms{
  display: flex;
  align-items: center;
  height: 440px;
  width: 200%;
  transition: height 0.2s ease;
}*/


/*.container .forms{*/
/*  width: 50%;*/
/*  padding: 30px;*/
/*  background-color: #fff;*/
/*  transition: margin-left 0.18s ease;*/
/*}*/

.container.active .login{
  margin-left: -50%;
  opacity: 0;
  transition: margin-left 0.18s ease, opacity 0.15s ease;
}

.container .signup{
  opacity: 0;
  transition: opacity 0.09s ease;
}
.container.active .signup{
  opacity: 1;
  transition: opacity 0.2s ease;
}
/*
.container.active .forms{
  height: 600px;
}
.container .forms .title{
  position: relative;
  font-size: 27px;
  font-weight: 600;
}

.form .title::before{
  content: '';
  position: absolute;
  left: 0;
  bottom: 0;
  height: 3px;
  width: 30px;
  background-color: #4070f4;
  border-radius: 25px;
}

.forms .input-field{
  position: relative;
  height: 50px;
  width: 100%;
  margin-top: 30px;
}

.input-field input{
  position: absolute;
  height: 100%;
  width: 100%;
  padding: 0 35px;
  border: none;
  outline: none;
  font-size: 16px;
  border-bottom: 2px solid #ccc;
  border-top: 2px solid transparent;
  transition: all 0.2s ease;
}


input-field input:focus{
  border-bottom-color: #4070f4;
}

input-field input:valid{
  border-bottom-color: #4070f4;
}

.input-field i{
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  color: #999;
  font-size: 23px;
  transition: all 0.2s ease;
}

.input-field input:focus ~ i{
  color: #4070f4;
}

.input-field input:valid ~ i{
  color: #4070f4;
}

.input-field i.icon{
  left: 0;
}
.input-field i.showHidePw{
  right: 0;
  cursor: pointer;
  padding: 10px;
}

.forms .checkbox-text{
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-top: 20px;
}

.checkbox-text .checkbox-content{
  display: flex;
  align-items: center;
}

.checkbox-content input{
  margin: 0 8px -2px 4px;

}

.forms .text{
  color: #333;
  font-size: 14px;
}

.forms a.text{
  color: #4070f4;
  text-decoration: none;
}
.form a:hover{
  text-decoration: underline;
}

.forms .button{
  margin-top: 35px;
}

.forms .button input{
  border: none;
  color: #fff;
  font-size: 17px;
  font-weight: 500;
  letter-spacing: 1px;
  border-radius: 6px;
  background-color: #4070f4;
  cursor: pointer;
  transition: all 0.3s ease;
}

.button input:hover{
  background-color: #265df2;
}

.forms .login-signup{
  margin-top: 30px;
  text-align: center;
}*/
</style>