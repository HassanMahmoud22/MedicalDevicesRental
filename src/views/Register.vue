<template>
  <div class="container">
    <h1 id="title">Register</h1>

    <div class="info">
      <label ><b>Hospital Name</b></label>
      <input type="text" placeholder="Enter hospital name" name="uname" v-model="name">
      <br><br>

      <label ><b>Hospital Location</b></label>
      <input type="text" placeholder="Enter hospital location" name="uname" v-model="location">
      <br><br>

      <label ><b>phone Number</b></label>
      <input type="text" placeholder="Enter phone number" name="uname" v-model="phone">
      <br><br>

      <label ><b>Username</b></label>
      <input type="text" placeholder="Enter username" name="uname" v-model="username">
      <br><br>

      <label ><b>Password</b></label>
      <input type="password" placeholder="Enter password" name="psw" v-model="pw">
      <br><br>

      <button v-on:click="register()">Register</button>
      <p>{{errorMsg}}</p>
    </div>
  </div>
</template>

<script>

import axios from 'axios';

export default {
  name: "Register",
  components: {
  },
  data(){
    return({
      name: '',
      location: '',
      phone:'',
      username: '',
      pw: '',
      errorMsg: ''
    })
  },
  methods:{
    register(){
      this.errorMsg = ''
      if(this.isEmpty()){
        // format json object
        const hospitalJson = {
          "username": this.username,
          "password": this.pw,
          "role": "hospital",
          "name": this.name,
          "address": this.location,
          "phone_number": this.phone
        };


        //post json object
        //axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
        console.log(hospitalJson)
        try {
          axios.post("https://medicaldevicesrental.herokuapp.com/api/hospital/register", hospitalJson,{
            headers: {
              "Access-Control-Allow-Origin": "*",
              "content-Type": "application/json",
            }
          }).then(response => console.log(response.data));

          this.$router.push({name:'SearchPage',params: {name: hospitalJson.name} })
        }
        catch(err) {
          this.errorMsg = 'Username is already used'
        }

      }else{
        this.errorMsg = 'Please fill all fields'
      }
    },
    isEmpty(){
      return this.name.length != 0 && this.location.length != 0 && this.phone.length != 0  && this.username.length != 0 && this.pw.length != 0
    }
  }
}
</script>

<style scoped>

.container{
  width: 100%;
  height: 100%;
  min-height: 720px;
}

#title{
  font-size: 100px;
  padding-top: 68px;
}

.info{
  margin: 50px;
}

.info *{
  padding: 10px;
}

</style>