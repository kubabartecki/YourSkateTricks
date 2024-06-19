/** @type {import('next').NextConfig} */
const nextConfig = {
  reactStrictMode: true,
  swcMinify: true,
  serverRuntimeConfig: {
    // these variables are from kubernetes configuration yaml file

    // available only when request are from server side
    // empty or undefined when from client side
    API_BASE_URL: process.env.SERVER_SIDE_API_BASE_URL
  },
  publicRuntimeConfig: {
    // contains client side url
    API_BASE_URL: process.env.CLIENT_SIDE_API_BASE_URL
  },
  async redirects() {
    return [
      {
        source: "/",
        destination: "/tricks",
        permanent: true,
      },
    ]
  },
};

export default nextConfig;
