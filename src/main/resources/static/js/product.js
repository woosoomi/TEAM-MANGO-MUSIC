

document.addEventListener('DOMContentLoaded', function () {
    const searchInput = document.getElementById('searchInput');
    var titleElements = document.querySelectorAll('.movie-item-style-2 h6 a');
    var productContainer = document.getElementById('productContainer');

    searchInput.addEventListener('keydown', function (event) {
        if (event.key === 'Enter') {
            const searchValue = searchInput.value;

            filterItems(searchValue);
            searchInput.value = ''; 
        }
    });

    function filterItems(searchQuery) {
        productContainer.innerHTML = ''; 

        titleElements.forEach(function (titleElement, index) {
            var title = titleElement.textContent;
            console.log("title: " + title);

            if (title.toLowerCase().includes(searchQuery.toLowerCase())) {
                var item = titleElement.closest('.movie-item-style-2'); 
                productContainer.appendChild(item);
            }
        });
    }
});

