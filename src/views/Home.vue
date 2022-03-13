<template>
  <div class="home">
    <h1 id="title">{{title}}</h1>
    <p id="subtitle">{{subtitle}}</p>
    <p id="info">{{info}}</p>
    <div class="nav_buttons">
      <button type="button" class="nav_button" v-on:click="goToLogin">Login</button>
      <button type="button" class="nav_button" v-on:click="goToReg">Register</button>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
//import HelloWorld from '@/components/HelloWorld.vue'
// import axios from 'axios';

export default {
  name: 'Home',
  components: {
  },
  data(){
    return({
      title: 'Rently',
      subtitle: 'for medical equipment and staff services',
      info: 'Not Like all suppliers, we will not force you to buy the device. You can rent it for a certain period. This will reduce a lot of money required to own the device for a short period.\n' +
          '        Through us,Also you can appoint many highly qualified doctors and nurses to work with you in a certain period.\n'
    })
  },
  methods:{
    goToLogin(){
      console.log('go to login')
      this.$router.push({name:'Login'})
    },
    goToReg(){
      console.log('go to register')
      this.$router.push({name:'Register'})
    }
  },
  mounted() {

  }
}
</script>

<style>

.home{
  margin: 0px;
  padding: 0px;
}

#title{
  font-size: 100px;
  padding-top: 68px;
}

#subtitle{
  font-size: 40px;
  padding-top: 20px;
}

#info{
  font-size: 23px;
  padding: 35px;
  margin: 0 250px;
  line-height: 2;
  background-color: rgba(0, 145, 255, 0.4);
  border-radius: 8px;
}

.nav_button {
  border-radius: 5px;
  font-family: Arial;
  color: #ffffff;
  font-size: 20px;
  background: rgba(44, 62, 80, 0.9);
  margin: 50px 50px 50px 50px;
  padding: 10px;
  text-decoration: none;
  border: none;
  width: 10%;
}

.nav_button:hover {
  background: rgba(44, 62, 80, 0.7);
  text-decoration: none;
}
</style>