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

</style>