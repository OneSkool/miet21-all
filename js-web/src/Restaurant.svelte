<script>
    export let id;
    export let name;
    export let description;
</script>

<main>
    <ul>
        <li>Id: {id}</li>
        <li>Name: <a href="/restaurants/{id}"> {name} </a> </li>
        <li>Description: {description}</li>
    </ul>
</main>


<style>

    li {
        color: #003ef0;
    }
</style>>
