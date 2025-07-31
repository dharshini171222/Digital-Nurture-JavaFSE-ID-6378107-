import React, { useState } from 'react';

function App() {
  const posts = [
    {
      id: 1,
      title: 'Why Developers Love Spring Boot',
      body: 'Spring Boot simplifies Java development with auto-configuration and embedded servers.',
      extended: 'Spring Boot eliminates boilerplate setup and promotes rapid development. With built-in server support and integration with Spring Cloud, it’s perfect for building scalable microservices. You can easily annotate your classes with @RestController and let the framework handle routing, configuration, and service discovery.',
      image: 'https://source.unsplash.com/600x250/?spring,code'
    },
    {
      id: 2,
      title: 'Demystifying Git Merge Conflicts',
      body: 'Learn how to resolve conflicting changes and keep your history clean.',
      extended: 'Merge conflicts happen when two branches edit the same part of a file. Resolving them requires understanding the HEAD and incoming sections, carefully reviewing changes, and using tools like VS Code’s conflict helper or Git CLI. Keeping your commit history clean also helps future collaborators debug less.',
      image: 'https://source.unsplash.com/600x250/?git,conflict'
    },
    {
      id: 3,
      title: 'React Tips: Breaking Down Components',
      body: 'Modular components improve reusability and readability.',
      extended: 'Breaking components into small, reusable units simplifies your JSX structure and enhances testing and scalability. Use hooks like useEffect, pass dynamic data through props, and organize files by feature or view for a maintainable codebase.',
      image: 'https://source.unsplash.com/600x250/?react,ui'
    }
  ];

  const [expandedId, setExpandedId] = useState(null);

  const toggleReadMore = (id) => {
    setExpandedId(prev => (prev === id ? null : id));
  };

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif', backgroundColor: '#f5f5f5' }}>
      <h1 style={{ textAlign: 'center' }}>Blog Posts</h1>
      {posts.map(post => (
        <div key={post.id} style={{
          backgroundColor: '#fff',
          borderRadius: '8px',
          overflow: 'hidden',
          boxShadow: '0 4px 8px rgba(0,0,0,0.1)',
          margin: '20px auto',
          maxWidth: '600px'
        }}>
          <img src={post.image} alt={post.title} style={{ width: '100%', height: 'auto' }} />
          <div style={{ padding: '20px' }}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
            <button onClick={() => toggleReadMore(post.id)} style={{
              backgroundColor: '#007BFF',
              color: '#fff',
              border: 'none',
              padding: '10px 15px',
              borderRadius: '4px',
              cursor: 'pointer'
            }}>
              {expandedId === post.id ? 'Show Less' : 'Read More'}
            </button>
            {expandedId === post.id && (
              <div style={{ marginTop: '15px', color: '#555' }}>
                <p>{post.extended}</p>
              </div>
            )}
          </div>
        </div>
      ))}
    </div>
  );
}

export default App;
