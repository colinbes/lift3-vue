<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <RTPage msg="Liftweb Vue.js + TypeScript App"/>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'
import RTPage from '@/components/RTPage.vue' // @ is an alias to /src

export default Vue.extend({
  name: 'home',
  components: {
    RTPage
  }
})
</script>
