// src/components/HelloWorld.vue
<template>
  <div>{{ msg }}</div>
</template>

<script setup>
defineProps({
  msg: {
    type: String,
    default: 'Hello World'
  }
})
</script>