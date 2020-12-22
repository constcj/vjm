<template>
<div class="app">
   <router-view/>
</div>
</template>

<style>
.app{
  position: absolute;
  top: 0px;
  left: 0px;
  width:100%;
  height:100%;

}
</style>

<script>
  export default {
    name:'app',

     data() {
    return {
      name: "张三"
    };
  },

  }
</script>
